package cn.ld.app.award.cmd;

import cn.ld.app.assembler.AwardAssembler;
import cn.ld.client.dto.cmd.AwardUpdateCmd;
import cn.ld.client.dto.vo.AwardVO;
import cn.ld.config.util.Assertutil;
import cn.ld.domain.award.AwardEntity;
import cn.ld.domain.gateway.AwardGateWay;
import cn.ld.domain.gateway.PrizeGateWay;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 19:55
 */
@Component
@AllArgsConstructor
public class AwardUpdateCmdExe {

    private final AwardGateWay awardGateWay;

    public AwardVO execute(AwardUpdateCmd cmd) {
        AwardEntity awardEntity = awardGateWay.save(AwardAssembler.toUpdateEntity(cmd));
        return AwardAssembler.toAwardVO(awardEntity);
    }
}
