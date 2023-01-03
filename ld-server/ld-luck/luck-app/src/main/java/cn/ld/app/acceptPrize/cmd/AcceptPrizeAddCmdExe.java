package cn.ld.app.acceptPrize.cmd;

import cn.ld.app.assembler.AcceptPrizeAssembler;
import cn.ld.client.dto.cmd.AcceptPrizeAddCmd;
import cn.ld.client.dto.vo.AcceptPrizeVO;
import cn.ld.domain.acceptPrize.AcceptPrizeEntity;
import cn.ld.domain.gateway.AcceptPrizeGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 15:40
 */
@Component
@AllArgsConstructor
public class AcceptPrizeAddCmdExe {

    private final AcceptPrizeGateway acceptPrizeGateway;

    public AcceptPrizeVO excute(AcceptPrizeAddCmd cmd) {
        AcceptPrizeEntity entity = acceptPrizeGateway.save(AcceptPrizeAssembler.toEntity(cmd));
        return AcceptPrizeAssembler.toAcceptPrizeVO(entity);
    }
}
