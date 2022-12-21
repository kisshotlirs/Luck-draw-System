package cn.ld.app.assembler;
import java.time.LocalDateTime;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.client.dto.cmd.ActivityRuleAddCmd;
import cn.ld.client.dto.vo.ActivityRuleVO;
import cn.ld.config.util.SecurityUtil;
import cn.ld.domain.activityRule.ActivityRuleEntity;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 18:10
 */
public class ActivityRuleAssembler {

    public static ActivityRuleEntity toAddEntity(ActivityRuleAddCmd cmd) {
        ActivityRuleEntity entity = new ActivityRuleEntity();
        entity.setActivityId(cmd.getActivityId());
        entity.setRuleId(cmd.getRuleId());
        entity.setCreateTime(LocalDateTime.now());
        entity.setCreator(SecurityUtil.getName());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdater(SecurityUtil.getName());
        return entity;
    }

    public static ActivityRuleVO toVo(ActivityRuleEntity entity) {
        ActivityRuleVO ruleVO = new ActivityRuleVO();
        if (ObjectUtil.isNotNull(entity.getId())){
            ruleVO.setId(entity.getId());
        }
        ruleVO.setActivityId(0L);
        ruleVO.setRuleId(0L);
        ruleVO.setCreateTime(LocalDateTime.now());
        ruleVO.setCreator("");
        ruleVO.setUpdateTime(LocalDateTime.now());
        ruleVO.setUpdater("");
        return ruleVO;
    }
}
