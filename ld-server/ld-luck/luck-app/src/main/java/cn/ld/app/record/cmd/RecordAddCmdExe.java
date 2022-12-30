package cn.ld.app.record.cmd;

import cn.ld.app.assembler.RecordAssembler;
import cn.ld.client.dto.cmd.RecordAddCmd;
import cn.ld.client.dto.vo.RecordVO;
import cn.ld.domain.gateway.RecordGateway;
import cn.ld.domain.record.RecordEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/30 0030 11:27
 */
@Component
@AllArgsConstructor
public class RecordAddCmdExe {

    private final RecordGateway recordGateway;

    public RecordVO execute(RecordAddCmd cmd) {
        RecordEntity recordEntity = recordGateway.save(RecordAssembler.toAddEntity(cmd));
        return RecordAssembler.toVO(recordEntity);
    }
}
