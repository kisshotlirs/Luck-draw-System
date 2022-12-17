package cn.ld.app.rule.cmd;

import cn.ld.app.assembler.RuleAssembler;
import cn.ld.client.dto.cmd.RuleAddCmd;
import cn.ld.client.dto.vo.RuleVO;
import cn.ld.domain.gateway.RuleGateWay;
import cn.ld.domain.rule.RuleEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 17:12
 */
@Component
@AllArgsConstructor
public class RuleAddCmdExe {

    private final RuleGateWay ruleGateWay;

    public RuleVO execute(RuleAddCmd cmd) {

        RuleEntity ruleEntity = ruleGateWay.save(RuleAssembler.toAddEntity(cmd));

        return RuleAssembler.toRuleVO(ruleEntity);
    }
}
