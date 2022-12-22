package cn.ld.app.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.ld.app.activity.cmd.ActivityAddCmdExe;
import cn.ld.app.activity.cmd.ActivityUpdateCmdExe;
import cn.ld.app.activity.query.ActivityListQueryExe;
import cn.ld.app.activityConfig.cmd.ActivityConfigAddCmdExe;
import cn.ld.app.activityConfig.cmd.ActivityConfigUpdateCmdExe;
import cn.ld.app.activityConfig.query.ActivityConfigGetQueryExe;
import cn.ld.app.activityRule.cmd.ActivityRuleAddCmdExe;
import cn.ld.app.activityRule.cmd.ActivityRuleDeleteCmdExe;
import cn.ld.app.activityRule.query.ActivityRuleListQueryExe;
import cn.ld.app.assembler.ActivityAssembler;
import cn.ld.app.assembler.AwardAssembler;
import cn.ld.app.award.cmd.AwardAddCmdExe;
import cn.ld.app.award.cmd.AwardUpdateCmdExe;
import cn.ld.app.award.query.AwardListQueryCmdExe;
import cn.ld.app.rule.cmd.RuleAddCmdExe;
import cn.ld.app.rule.cmd.RuleUpdateCmdExe;
import cn.ld.app.rule.query.RuleListQueryCmdExe;
import cn.ld.client.api.ActivityConfigService;
import cn.ld.client.dto.cmd.*;
import cn.ld.client.dto.query.ActivityListQuery;
import cn.ld.client.dto.query.ActivityRuleListQuery;
import cn.ld.client.dto.query.AwardListQuery;
import cn.ld.client.dto.query.RuleListQuery;
import cn.ld.client.dto.vo.*;
import cn.ld.config.util.Assertutil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

        List<RuleVO> activityRuleVOList = addActivityRule(activityVO, cmd.getRuleIdList());

        List<AwardVO> awardVOList = addAward(activityVO, cmd.getAwardAddCmdList());

        ActivityConfigVO activityConfigVO = new ActivityConfigVO();
        activityConfigVO.setActivityVO(activityVO);
        activityConfigVO.setRuleVOList(activityRuleVOList);
        activityConfigVO.setAwardVOList(awardVOList);
        return activityConfigVO;
    }

    @Deprecated
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ActivityConfigVO update(ActivityConfigUpdateCmd cmd) {
        ActivityVO activityVO = activityUpdateCmdExe.execute(cmd.getActivityUpdateCmd());
        activityRuleDeleteCmdExe.execute(activityVO.getId());
        List<RuleVO> ruleVOList = addActivityRule(activityVO, cmd.getRuleIdList());

        List<AwardVO> awardVOList = updateAward(activityVO,cmd.getAwardUpdateCmdList());

        ActivityConfigVO activityConfigVO = new ActivityConfigVO();
        activityConfigVO.setActivityVO(activityVO);
        activityConfigVO.setRuleVOList(ruleVOList);
        activityConfigVO.setAwardVOList(awardVOList);
        return activityConfigVO;
    }

    @Override
    public ActivityConfigVO getOne(Long id) {
        ActivityListQuery activityListQuery = new ActivityListQuery();
        activityListQuery.setId(id);
        List<ActivityVO> activityVOS = activityListQueryExe.execute(activityListQuery).getRecords();
        Assertutil.isTrue(CollectionUtil.isEmpty(activityVOS),"活动数据不存在");

        ActivityConfigVO activityConfigVO = new ActivityConfigVO();

        ActivityVO activityVO = activityVOS.get(0);
        ActivityRuleListQuery activityRuleListQuery = new ActivityRuleListQuery();
        activityRuleListQuery.setActivityId(activityVO.getId());

        List<ActivityRuleVO> activityRuleVOS = activityRuleListQueryExe.execute(activityRuleListQuery);

        AwardListQuery awardListQuery = new AwardListQuery();
        awardListQuery.setActivityId(activityVO.getId());
        awardListQuery.setPageSize(100);
        List<AwardVO> awardVOList = awardListQueryCmdExe.execute(awardListQuery).getRecords();

        List<RuleVO> ruleVOList = getRuleVOList(activityRuleVOS.stream().map(ActivityRuleVO::getRuleId).collect(Collectors.toList()));

        activityConfigVO.setActivityVO(activityVO);
        activityConfigVO.setRuleVOList(ruleVOList);
        activityConfigVO.setAwardVOList(awardVOList);
        return activityConfigVO;
    }

    @Override
    public ActivityConfigCopyVO copy(Long id) {
        ActivityConfigCopyVO copyVO = new ActivityConfigCopyVO();

        ActivityConfigVO activityConfigVO = getOne(id);
        ActivityVO activityVO = activityConfigVO.getActivityVO();

        copyVO.setActivityAddCmd(ActivityAssembler.toAddCmd(activityVO));
        copyVO.setRuleIdList(activityConfigVO.getRuleVOList().stream().map(RuleVO::getId).collect(Collectors.toList()));
        copyVO.setAwardAddCmdList(
                new Page<AwardVO>().setRecords(activityConfigVO.getAwardVOList())
                        .convert(AwardAssembler::toAddCmd).getRecords()
        );
        return copyVO;
    }

    @Deprecated
    private List<AwardAddCmd> getAwardAddCmdList(ActivityConfigVO activityConfigVO) {
        List<AwardAddCmd> awardAddCmdList = new ArrayList<>();

        for (AwardVO awardVO : activityConfigVO.getAwardVOList()) {
            AwardAddCmd awardAddCmd = AwardAssembler.toAddCmd(awardVO);
            awardAddCmdList.add(awardAddCmd);
        }
        return awardAddCmdList;
    }

    private List<RuleVO> getRuleVOList(List<Long> ruleIdList){
        RuleListQuery ruleListQuery = new RuleListQuery();
        ruleListQuery.setIds(ruleIdList);
        ruleListQuery.setPageSize(1000);
        return ruleListQueryCmdExe.execute(ruleListQuery).getRecords();
    }

    private List<AwardVO> updateAward(ActivityVO activityVO, List<AwardUpdateCmd> awardUpdateCmdList) {
        Assertutil.isTrue(CollectionUtil.isEmpty(awardUpdateCmdList),"奖项更新列表不为空");

        List<AwardVO> awardVOList = new ArrayList<>();
        for (AwardUpdateCmd awardUpdateCmd : awardUpdateCmdList) {
            AwardVO awardVO = awardUpdateCmdExe.execute(awardUpdateCmd);
            awardVOList.add(awardVO);
        }
        return awardVOList;
    }

    private List<AwardVO> addAward(ActivityVO activityVO, List<AwardAddCmd> awardAddCmdList) {
        Assertutil.isTrue(CollectionUtil.isEmpty(awardAddCmdList),"奖项添加列表不为空");

        ArrayList<AwardVO> awardVOS = new ArrayList<>();
        for (AwardAddCmd awardAddCmd : awardAddCmdList) {
            awardAddCmd.setActivityId(activityVO.getId());
            AwardVO awardVO = awardAddCmdExe.execute(awardAddCmd);
            awardVOS.add(awardVO);

            //// TODO: 2022/12/22 0022 添加完奖项后扣除奖品库存 在奖项的执行器中
        }
        return awardVOS;
    }

    /**
     * 添加若干规则
     */
    private List<RuleVO> addActivityRule(ActivityVO activityVO, List<Long> ruleIdList) {
        List<ActivityRuleAddCmd> ruleAddCmds = new ArrayList<>();
        for (Long ruleId : ruleIdList) {
            ActivityRuleAddCmd activityRuleAddCmd = new ActivityRuleAddCmd();
            activityRuleAddCmd.setActivityId(activityVO.getId());
            activityRuleAddCmd.setRuleId(ruleId);
            ruleAddCmds.add(activityRuleAddCmd);
        }
        List<ActivityRuleVO> activityRuleVOList = activityRuleAddCmdExe.execute(ruleAddCmds);

        return getRuleVOList(activityRuleVOList.stream().map(ActivityRuleVO::getRuleId).collect(Collectors.toList()));
    }
}
