package cn.ld.app.activity.cmd;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.WeightRandom;
import cn.hutool.core.util.RandomUtil;
import cn.ld.app.assembler.AwardAssembler;
import cn.ld.app.context.ActivityDrawContext;
import cn.ld.client.dto.vo.*;
import cn.ld.config.exception.LdException;
import cn.ld.config.util.Assertutil;
import cn.ld.domain.activity.ActivityEntity;
import cn.ld.domain.activity.ActivityStatusEnum;
import cn.ld.domain.activity.ActivityTime;
import cn.ld.domain.award.AwardEntity;
import cn.ld.domain.gateway.AwardGateWay;
import cn.ld.domain.gateway.PrizeGateWay;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mojo
 * @description: 默认的 抽奖实现
 * @date 2022/12/27 0027 20:50
 */
@Slf4j
@Getter
@Component
@AllArgsConstructor
public abstract class DefaultDrawExe extends BaseDrawExe{

    private final AwardGateWay awardGateWay;

    private final PrizeGateWay prizeGateWay;

    private TransactionTemplate transactionTemplate;


    public void addRecord(ActivityDrawContext context) {
        //// TODO: 2022/12/27 0027
    }

    @Override
    protected Boolean drawBefore(ActivityDrawContext context) {

        return transactionTemplate.execute(status -> {
            Boolean success = Boolean.TRUE;
            try {
                int update = awardGateWay.deductionAwardNumber(context.getAwardVO().getId(), 1);
                Assertutil.isTrue(update!=1,"扣减库存失败！");
                //插入记录
                addRecord(context);
            }catch (Exception e){
                //错误处理
                status.setRollbackOnly();
                //回退库存
                awardGateWay.deductionAwardNumber(context.getAwardVO().getId(), -1);
                success = Boolean.FALSE;
                log.error("扣减库存失败或者发送MQ消息失败......",e);
            }
            return success;
        });
    }

    @Override
    protected DrawResultVO getDrawResultVO(AwardEntity awardEntity) {
        DrawResultVO resultVO = new DrawResultVO();
        resultVO.setAwardName(awardEntity.getAwardName());

        //设置奖品名称
        String prizeName = prizeGateWay.getOne(awardEntity.getPrizeId()).getPrizeName();
        resultVO.setPrizeName(prizeName);

        resultVO.setIsDraw(awardEntity.isPrize());
        return resultVO;
    }

    @Override
    protected AwardVO getAward(List<AwardVO> awardVOList) {
        /*
        抽奖算法：
        1.权重
         */
        List<WeightRandom.WeightObj<AwardVO>> weightList = new ArrayList<>();
        awardVOList.forEach(item-> weightList.add(new WeightRandom.WeightObj<>(item, item.getProbability())));
        //创建带有权重的随机生成器
        WeightRandom<AwardVO> random = RandomUtil.weightRandom(weightList);
        return random.next();
    }

    @Override
    protected List<AwardVO> removeAwardInventoryNull(List<AwardVO> awardVOList) {
        if (CollectionUtil.isEmpty(awardVOList)){
            return new ArrayList<>();
        }

        return awardVOList.stream()
                //过滤掉没有库存  如果不是奖品也可以参与抽奖
                .filter(item -> item.getNumber() > 0 || "0".equals(item.getPrizeId().toString()))
                .collect(Collectors.toList());
    }

    @Override
    protected void checkActivityTime(ActivityVO activityVO) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setActivityTime(new ActivityTime(activityVO.getStartTime(),activityVO.getEndTime()));
        ActivityStatusEnum status = activityEntity.getActivityTime().getStatus();
        if (ActivityStatusEnum.NOT_START.equals(status)){
            throw new LdException(String.format("活动%s", ActivityStatusEnum.NOT_START.getDescription()));
        }
        if (ActivityStatusEnum.END.equals(status)){
            throw new LdException(String.format("活动%s", ActivityStatusEnum.END.getDescription()));
        }
    }

    @Override
    protected void checkActivityRule(ActivityConfigVO activityConfigVO) {
        List<RuleVO> ruleVOList = activityConfigVO.getRuleVOList();
        //// TODO: 2022/12/23 0023
    }

}
