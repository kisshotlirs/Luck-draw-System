package cn.ld.app.activity.cmd;

import cn.ld.app.assembler.ActivityAssembler;
import cn.ld.client.dto.cmd.ActivityUpdateCmd;
import cn.ld.client.dto.vo.ActivityVO;
import cn.ld.domain.activity.ActivityEntity;
import cn.ld.domain.gateway.ActivityGateWay;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 16:51
 */
@Component
@AllArgsConstructor
public class ActivityUpdateCmdExe {

    private final ActivityGateWay activityGateWay;

    public ActivityVO execute(ActivityUpdateCmd cmd) {
        ActivityEntity entity = activityGateWay.save(ActivityAssembler.toUpdateEntity(cmd));
        return ActivityAssembler.toActivityVO(entity);
    }
}
