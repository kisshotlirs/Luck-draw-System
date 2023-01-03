package cn.ld.app.acceptPrize.query;

import cn.ld.app.assembler.AcceptPrizeAssembler;
import cn.ld.client.dto.vo.AcceptPrizeVO;
import cn.ld.domain.acceptPrize.AcceptPrizeEntity;
import cn.ld.domain.gateway.AcceptPrizeGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 15:41
 */
@Component
@AllArgsConstructor
public class AcceptPrizeListQueryExe {

    private final AcceptPrizeGateway acceptPrizeGateway;

    public AcceptPrizeVO excute(Long recordId) {
        AcceptPrizeEntity entity = acceptPrizeGateway.getOne(recordId);
        return AcceptPrizeAssembler.toAcceptPrizeVO(entity);
    }
}
