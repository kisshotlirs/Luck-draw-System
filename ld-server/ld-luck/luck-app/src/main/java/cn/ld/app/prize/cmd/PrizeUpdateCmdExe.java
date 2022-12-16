package cn.ld.app.prize.cmd;

import cn.ld.client.dto.cmd.PrizeUpdateCmd;
import cn.ld.client.dto.vo.PrizeVO;
import cn.ld.domain.gateway.PrizeGateWay;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/16 0016 22:40
 */
@Slf4j
@Component
@AllArgsConstructor
public class PrizeUpdateCmdExe {

    private final PrizeGateWay prizeGateWay;

    public PrizeVO execute(PrizeUpdateCmd cmd) {
        return null;
    }
}
