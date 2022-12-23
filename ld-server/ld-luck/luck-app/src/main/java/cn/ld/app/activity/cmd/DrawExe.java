package cn.ld.app.activity.cmd;

import cn.hutool.core.collection.CollectionUtil;
import cn.ld.client.api.ActivityService;
import cn.ld.client.dto.vo.*;
import cn.ld.config.exception.LdException;
import cn.ld.domain.activity.ActivityEntity;
import cn.ld.domain.activity.ActivityStatusEnum;
import cn.ld.domain.activity.ActivityTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mojo
 * @description: 用户抽奖 执行器
 * @date 2022/12/23 0023 16:43
 */
@Component
@AllArgsConstructor
public class DrawExe {

    public DrawResultVO execute(ActivityConfigVO activityConfigVO) {
        //校验活动时间
        checkActivityTime(activityConfigVO.getActivityVO());
        //校验活动规则
        checkActivityRule(activityConfigVO);
        //剔除奖项库存为空的项
        List<AwardVO> awardVOList  = removeAwardInventoryNull(activityConfigVO.getAwardVOList());
        //调用抽奖算法进行抽奖

        //扣减奖项库存

        //插入中奖记录

        //返回结果
        return null;
    }

    private List<AwardVO> removeAwardInventoryNull(List<AwardVO> awardVOList) {
        if (CollectionUtil.isEmpty(awardVOList)){
            return new ArrayList<>();
        }

        return null;
    }

    private void checkActivityTime(ActivityVO activityVO) {
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

    private void checkActivityRule(ActivityConfigVO activityConfigVO) {
        List<RuleVO> ruleVOList = activityConfigVO.getRuleVOList();
        //// TODO: 2022/12/23 0023
    }
}
