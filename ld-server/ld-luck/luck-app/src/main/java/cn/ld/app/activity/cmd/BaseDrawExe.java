package cn.ld.app.activity.cmd;

import cn.ld.app.assembler.AwardAssembler;
import cn.ld.app.context.ActivityDrawContext;
import cn.ld.client.dto.vo.ActivityConfigVO;
import cn.ld.client.dto.vo.ActivityVO;
import cn.ld.client.dto.vo.AwardVO;
import cn.ld.client.dto.vo.DrawResultVO;
import cn.ld.domain.award.AwardEntity;

import java.util.List;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/27 0027 20:29
 */
public abstract class BaseDrawExe {

    /**
     * 抽奖模板方法 流程不会改动
     * @param context 抽奖活动上下文 对象
     */
    public DrawResultVO execute(ActivityDrawContext context) {
        //校验活动时间
        checkActivityTime(context.getActivityConfigVO().getActivityVO());
        //校验活动规则
        checkActivityRule(context.getActivityConfigVO());
        //剔除奖项库存为空的项
        List<AwardVO> awardVOList  = removeAwardInventoryNull(context.getActivityConfigVO().getAwardVOList());
        //调用抽奖算法进行抽奖  将抽奖结果设置进入上下文
        //AwardVO awardVO = getAward(awardVOList);
        context.setAwardVO(getAward(awardVOList));

        //AwardEntity awardEntity = AwardAssembler.toAwardEntity(context.getAwardVO());
        context.setAwardEntity(AwardAssembler.toAwardEntity(context.getAwardVO()));

        if (!context.getAwardEntity().isPrize()){
            //不是奖项，不用扣减库存
            return getDrawResultVO(context.getAwardEntity());}

        //抽奖结果，发送MQ消息 由该方法决定
        Boolean draw = drawBefore(context);
        if (Boolean.FALSE.equals(drawBefore(context))){
            return getDefaultDrawResultVO(context.getActivityConfigVO().getAwardVOList());
        }

        //返回结果
        return getDrawResultVO(context.getAwardEntity());
    }

    protected abstract Boolean drawBefore(ActivityDrawContext context);

    /**
     * 从奖项中找到一个没有中奖的返回
     */
    private DrawResultVO getDefaultDrawResultVO(List<AwardVO> awardVOList){
        DrawResultVO resultVO = new DrawResultVO();
        for (AwardVO awardVO : awardVOList) {
            if ("0".equals(awardVO.getPrizeId().toString())){
                resultVO = getDrawResultVO(AwardAssembler.toAwardEntity(awardVO));
                break;
            }
        }
        return resultVO;
    };

    protected abstract DrawResultVO getDrawResultVO(AwardEntity awardEntity);

    protected abstract AwardVO getAward(List<AwardVO> awardVOList);

    protected abstract List<AwardVO> removeAwardInventoryNull(List<AwardVO> awardVOList);

    protected abstract void checkActivityRule(ActivityConfigVO activityConfigVO);

    protected abstract void checkActivityTime(ActivityVO activityVO);
}
