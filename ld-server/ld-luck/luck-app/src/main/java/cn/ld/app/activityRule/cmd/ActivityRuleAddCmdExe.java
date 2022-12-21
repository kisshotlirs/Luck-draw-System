package cn.ld.app.activityRule.cmd;

import cn.hutool.core.collection.CollectionUtil;
import cn.ld.app.assembler.ActivityRuleAssembler;
import cn.ld.client.dto.cmd.ActivityAddCmd;
import cn.ld.client.dto.cmd.ActivityRuleAddCmd;
import cn.ld.client.dto.vo.ActivityRuleVO;
import cn.ld.client.dto.vo.ActivityVO;
import cn.ld.config.exception.LdException;
import cn.ld.domain.activityRule.ActivityRuleEntity;
import cn.ld.domain.gateway.ActivityRuleGateWay;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 17:48
 */
@Component
@AllArgsConstructor
public class ActivityRuleAddCmdExe {

    private final ActivityRuleGateWay activityRuleGateWay;

    public ActivityRuleVO execute(ActivityRuleAddCmd cmd) {
        ActivityRuleEntity entity = activityRuleGateWay.save(ActivityRuleAssembler.toAddEntity(cmd));
        return ActivityRuleAssembler.toVo(entity);
    }

    public List<ActivityRuleVO> execute(List<ActivityRuleAddCmd> cmdList){
        if (CollectionUtil.isEmpty(cmdList)){
            throw new LdException("数据为空！");
        }

        List<ActivityRuleVO> activityVOS = new ArrayList<>();
        for (ActivityRuleAddCmd cmd : cmdList) {
            activityVOS.add(execute(cmd));
        }
        return activityVOS;
    }
}
