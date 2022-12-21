package cn.ld.app.service;

import cn.ld.app.activityRule.cmd.ActivityRuleAddCmdExe;
import cn.ld.app.activityRule.query.ActivityRuleListQueryExe;
import cn.ld.client.api.ActivityRuleService;
import cn.ld.client.dto.cmd.ActivityRuleAddCmd;
import cn.ld.client.dto.query.ActivityRuleListQuery;
import cn.ld.client.dto.vo.ActivityRuleVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 17:43
 */
@Service
@AllArgsConstructor
public class ActivityRuleServiceImpl implements ActivityRuleService {

    private final ActivityRuleAddCmdExe activityRuleAddCmdExe;

    private final ActivityRuleListQueryExe activityRuleListQueryExe;

    @Override
    public ActivityRuleVO add(ActivityRuleAddCmd cmd) {
        return activityRuleAddCmdExe.execute(cmd);
    }

    @Override
    public List<ActivityRuleVO> list(ActivityRuleListQuery query) {
        return activityRuleListQueryExe.execute(query);
    }
}
