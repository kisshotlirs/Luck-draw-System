package cn.ld.app.activityRule.cmd;

import cn.ld.domain.gateway.ActivityRuleGateWay;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 21:14
 */
@Component
@AllArgsConstructor
public class ActivityRuleDeleteCmdExe {

    private final ActivityRuleGateWay activityRuleGateWay;

    private void execute(Long activityId){
        activityRuleGateWay.delete(activityId);
    }
}
