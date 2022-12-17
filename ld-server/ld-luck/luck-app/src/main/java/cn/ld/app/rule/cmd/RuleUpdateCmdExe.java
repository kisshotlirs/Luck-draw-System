package cn.ld.app.rule.cmd;

import cn.ld.app.assembler.RuleAssembler;
import cn.ld.client.dto.cmd.RuleUpdateCmd;
import cn.ld.client.dto.vo.RuleVO;
import cn.ld.domain.gateway.RuleGateWay;
import cn.ld.domain.rule.RuleEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 17:15
 */
@Component
@AllArgsConstructor
public class RuleUpdateCmdExe {

    private final RuleGateWay ruleGateWay;

    public RuleVO execute(RuleUpdateCmd cmd) {
        RuleEntity ruleEntity = ruleGateWay.save(RuleAssembler.toUpdateEntity(cmd));

        return null;
    }
}
