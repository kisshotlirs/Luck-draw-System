package cn.ld.app.service;

import cn.ld.app.activity.cmd.ActivityAddCmdExe;
import cn.ld.app.activity.cmd.ActivityUpdateCmdExe;
import cn.ld.app.activity.query.ActivityListQueryExe;
import cn.ld.app.activityConfig.cmd.ActivityConfigAddCmdExe;
import cn.ld.app.activityConfig.cmd.ActivityConfigUpdateCmdExe;
import cn.ld.app.activityConfig.query.ActivityConfigGetQueryExe;
import cn.ld.app.activityRule.cmd.ActivityRuleAddCmdExe;
import cn.ld.app.activityRule.cmd.ActivityRuleDeleteCmdExe;
import cn.ld.app.activityRule.query.ActivityRuleListQueryExe;
import cn.ld.app.award.cmd.AwardAddCmdExe;
import cn.ld.app.award.cmd.AwardUpdateCmdExe;
import cn.ld.app.award.query.AwardListQueryCmdExe;
import cn.ld.app.rule.cmd.RuleAddCmdExe;
import cn.ld.app.rule.cmd.RuleUpdateCmdExe;
import cn.ld.app.rule.query.RuleListQueryCmdExe;
import cn.ld.client.api.ActivityConfigService;
import cn.ld.client.dto.cmd.ActivityConfigAddCmd;
import cn.ld.client.dto.cmd.ActivityConfigUpdateCmd;
import cn.ld.client.dto.cmd.ActivityRuleAddCmd;
import cn.ld.client.dto.query.RuleListQuery;
import cn.ld.client.dto.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mojo
 * @description: 活动配置整体服务
 * @date 2022/12/21 0021 15:13
 */
@Service
@AllArgsConstructor
public class ActivityConfigServiceImpl implements ActivityConfigService {

    private final ActivityAddCmdExe activityAddCmdExe;
    private final RuleAddCmdExe ruleAddCmdExe;
    private final ActivityRuleAddCmdExe activityRuleAddCmdExe;
    private final AwardAddCmdExe awardAddCmdExe;

    private final ActivityUpdateCmdExe activityUpdateCmdExe;
    private final RuleUpdateCmdExe ruleUpdateCmdExe;
    private final ActivityRuleDeleteCmdExe activityRuleDeleteCmdExe;
    private final AwardUpdateCmdExe awardUpdateCmdExe;

    private final ActivityListQueryExe activityListQueryExe;
    private final RuleListQueryCmdExe ruleListQueryCmdExe;
    private final ActivityRuleListQueryExe activityRuleListQueryExe;
    private final AwardListQueryCmdExe awardListQueryCmdExe;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ActivityConfigVO add(ActivityConfigAddCmd cmd) {
        ActivityVO activityVO = activityAddCmdExe.execute(cmd.getActivityAddCmd());

        //添加若干规则
        List<ActivityRuleAddCmd> ruleAddCmds = new ArrayList<>();
        for (Long ruleId : cmd.getRuleIdList()) {
            ActivityRuleAddCmd activityRuleAddCmd = new ActivityRuleAddCmd();
            activityRuleAddCmd.setActivityId(activityVO.getId());
            activityRuleAddCmd.setRuleId(ruleId);
            ruleAddCmds.add(activityRuleAddCmd);
        }
        List<ActivityRuleVO> activityRuleVOList = activityRuleAddCmdExe.execute(ruleAddCmds);

        //给奖项设置活动id
        cmd.getAwardAddCmd().setActivityId(activityVO.getId());
        AwardVO awardVO = awardAddCmdExe.execute(cmd.getAwardAddCmd());

        ActivityConfigVO activityConfigVO = new ActivityConfigVO();
        activityConfigVO.setActivityVO(activityVO);

        //// TODO: 2022/12/21 0021
        RuleListQuery ruleQuery = new RuleListQuery();
        ruleQuery.setIds(activityRuleVOList.stream().map(ActivityRuleVO::getRuleId).collect(Collectors.toList()));
        ruleQuery.setPageSize(100);
        activityConfigVO.setRuleVOList(ruleListQueryCmdExe.execute(ruleQuery).getRecords());

        activityConfigVO.setAwardVO(awardVO);
        return activityConfigVO;
    }

    @Override
    public ActivityConfigVO update(ActivityConfigUpdateCmd cmd) {
        ActivityVO activityVO = activityUpdateCmdExe.execute(cmd.getActivityUpdateCmd());
        //todo
        //RuleVO ruleVO = ruleUpdateCmdExe.execute(cmd.getRuleUpdateCmd());

        return null;
    }

    @Override
    public ActivityConfigVO getOne(Long id) {
        return null;
    }
}
