package cn.ld.app.award.cmd;

import cn.ld.app.assembler.AwardAssembler;
import cn.ld.client.dto.cmd.AwardAddCmd;
import cn.ld.client.dto.vo.AwardVO;
import cn.ld.domain.award.AwardEntity;
import cn.ld.domain.gateway.AwardGateWay;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 19:54
 */
@Component
@AllArgsConstructor
public class AwardAddCmdExe {

    private final AwardGateWay awardGateWay;

    public AwardVO execute(AwardAddCmd cmd) {
        AwardEntity entity = awardGateWay.save(AwardAssembler.toAddEntity(cmd));
        return AwardAssembler.toAwardVO(entity);
    }
}
