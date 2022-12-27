package cn.ld.app.activity.cmd;

import cn.ld.app.assembler.AwardAssembler;
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

    public DrawResultVO execute(ActivityConfigVO activityConfigVO) {
        //校验活动时间
        checkActivityTime(activityConfigVO.getActivityVO());
        //校验活动规则
        checkActivityRule(activityConfigVO);
        //剔除奖项库存为空的项
        List<AwardVO> awardVOList  = removeAwardInventoryNull(activityConfigVO.getAwardVOList());
        //调用抽奖算法进行抽奖
        AwardVO awardVO = getAward(awardVOList);

        AwardEntity awardEntity = AwardAssembler.toAwardEntity(awardVO);
        if (!awardEntity.isPrize()){
            //不是奖项，不用扣减库存
            return getDrawResultVO(awardEntity);}
        //扣减奖项库存
        int result = deductionAwardNumber(awardEntity.getId(), 1);
        if (result!=1){
            //扣减库存失败，用户未中奖   返回默认结果
            return getDefaultDrawResultVO(awardVOList);
        }
        //插入中奖记录
        addAcceptPrize(activityConfigVO.getActivityVO().getId(),awardEntity);
        //返回结果
        return getDrawResultVO(awardEntity);
    }

    protected abstract void addAcceptPrize(Long id, AwardEntity awardEntity);

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

    protected abstract int deductionAwardNumber(Long awardId, Integer number);

    protected abstract DrawResultVO getDrawResultVO(AwardEntity awardEntity);

    protected abstract AwardVO getAward(List<AwardVO> awardVOList);

    protected abstract List<AwardVO> removeAwardInventoryNull(List<AwardVO> awardVOList);

    protected abstract void checkActivityRule(ActivityConfigVO activityConfigVO);

    protected abstract void checkActivityTime(ActivityVO activityVO);
}
