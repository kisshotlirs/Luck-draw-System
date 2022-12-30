package cn.ld.app.activity.cmd;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.app.context.ActivityDrawContext;
import cn.ld.app.listener.AwardInventoryToRedisApplicationListener;
import cn.ld.app.mq.product.ActivityDrawMessageProduct;
import cn.ld.app.record.cmd.RecordAddCmdExe;
import cn.ld.client.dto.query.RecordListQuery;
import cn.ld.config.enums.RecordStatusEnum;
import cn.ld.config.exception.LdException;
import cn.ld.config.util.AssertUtil;
import cn.ld.config.util.FileLoadUtil;
import cn.ld.domain.gateway.AwardGateWay;
import cn.ld.domain.gateway.PrizeGateWay;
import cn.ld.domain.gateway.RecordGateway;
import cn.ld.domain.record.RecordEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author mojo
 * @description: 使用redis扣减库存
 * @date 2022/12/28 0028 11:13
 */
@Slf4j
@Component
public class RedisDeductionAwardNumberDrawExe extends DefaultDrawExe{

    private final RedisTemplate<String,Object> redisTemplate;

    private final ActivityDrawMessageProduct activityDrawMessageProduct;

    public RedisDeductionAwardNumberDrawExe(AwardGateWay awardGateWay, PrizeGateWay prizeGateWay,
                                            RedisTemplate<String,Object> redisTemplate,
                                            TransactionTemplate transactionTemplate,
                                            ActivityDrawMessageProduct activityDrawMessageProduct,
                                            RecordGateway recordGateway) {
        super(awardGateWay, prizeGateWay,transactionTemplate,recordGateway);
        this.redisTemplate = redisTemplate;
        this.activityDrawMessageProduct = activityDrawMessageProduct;
    }


    private static String stockDeductionLua;
    private static String stockRollbackLua;
    static {
        RedisDeductionAwardNumberDrawExe.stockDeductionLua = FileLoadUtil.read("lua/stock_deduction.lua");
        RedisDeductionAwardNumberDrawExe.stockRollbackLua = FileLoadUtil.read("lua/stock_rollback.lua");
    }

    @Override
    protected Boolean drawBefore(ActivityDrawContext context) {
        //扣减redis库存
        String key = AwardInventoryToRedisApplicationListener.getKey(context.getAwardVO().getActivityId(), context.getAwardVO().getId());
        Integer execute = invokeStockDeductionLua(key);

        // execute=-1表明库存扣减失败
        if (ObjectUtil.isNotNull(execute) && execute==-1){
            //扣减库存失败
            return Boolean.FALSE;
        }

        //使用编程式事务
        return super.getTransactionTemplate().execute(status -> {
            Boolean success = Boolean.TRUE;
            try {
                //扣减库存成功 插入不可见的抽奖记录
                context.setIsShow(Boolean.FALSE);
                super.addRecord(context);
                //发送MQ消息
                Boolean send = activityDrawMessageProduct.send(context);
                if (Boolean.FALSE.equals(send)){
                    //发送消息失败
                    throw new LdException("MQ发送消息失败");
                }
            }catch (Exception e){
                //发生错误回滚
                status.setRollbackOnly();
                //回退库存
                invokeStockRollBackLua(key);
                success = Boolean.FALSE;
                log.error("扣减库存失败或者发送MQ消息失败......",e);
            }
            return success;
        });
    }


    /**
     * 执行库存扣减的lua脚本
     */
    public Integer invokeStockDeductionLua(String key) {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(stockDeductionLua,Long.class);
        //要操作的key
        Long execute = redisTemplate.opsForValue().getOperations().execute(redisScript, List.of(key));
        if (ObjectUtil.isNull(execute) || execute==-1){
            //扣减库存失败
            return 0;
        }
        return 1;
    }

    /**
     * 执行库存回退的lua脚本
     */
    public Integer invokeStockRollBackLua(String key) {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(stockRollbackLua,Long.class);
        //要操作的key
        Long execute = redisTemplate.opsForValue().getOperations().execute(redisScript, List.of(key));
        if (ObjectUtil.isNull(execute) || execute<0){
            return 0;
        }
        return 1;
    }

    /**
     * MQ执行 扣减库存 并 修改中奖记录状态（将不可见变为可见）
     */
    public Boolean mqDeductionOfInventoryAndUpdateRecordStatus(ActivityDrawContext context) {
        return deductionOfInventoryAndUpdateRecordStatus(context.getAwardVO().getId());
    }

    /**
     * 扣减库存 并 修改中奖记录状态（将不可见变为可见）
     */
    public Boolean deductionOfInventoryAndUpdateRecordStatus(Long awardId) {
        return super.getTransactionTemplate().execute(status -> {
            Boolean success = Boolean.TRUE;

            try {
                //扣减库存
                int update = super.getAwardGateWay().deductionAwardNumber(awardId, -1);
                AssertUtil.isTrue(update!=1,"扣减库存失败");
                //修改不可见中奖记录状态
                Boolean updateStatus = super.getRecordGateway().updateStatus(awardId, RecordStatusEnum.STATUE_1.getValue());
                AssertUtil.isTrue(updateStatus,"修改不可见记录状态失败");
            }catch (Exception e){
                log.error("消费者执行扣减库存并修改中奖记录状态出错，",e);
                status.setRollbackOnly();
                success = Boolean.FALSE;
            }
            return success;
        });

    }

    /**
     * 定时任务执行
     */
    public void ScheduleExecuteDeductionOfInventoryAndUpdateRecordStatus() {
        /**
         * 定时扫描用户不可见状态的中奖记录，然后对比当前时间和数据创建时间，
         * 发现两者相隔10分钟，那么，定时任务就将这个数据查询出来，再执行一般方案三消费流程
         */
        LocalDateTime now = LocalDateTime.now().plusMinutes(-5);
        RecordListQuery query = new RecordListQuery();
        query.setState(RecordStatusEnum.STATUE_0.getValue());
        query.setPageSize(100);

        IPage<RecordEntity> page = super.getRecordGateway().page(query);
        for (RecordEntity record : page.getRecords()) {
            if (record.getCreateTime().isAfter(now)){
                //五分钟之内不执行
                continue;
            }
            deductionOfInventoryAndUpdateRecordStatus(record.getAwardId());
        }
    }
}
