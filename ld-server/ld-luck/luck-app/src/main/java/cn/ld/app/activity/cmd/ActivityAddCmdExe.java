package cn.ld.app.activity.cmd;

import cn.ld.app.assembler.ActivityAssembler;
import cn.ld.client.dto.cmd.ActivityAddCmd;
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
public class ActivityAddCmdExe {

    private final ActivityGateWay activityGateWay;

    public ActivityVO execute(ActivityAddCmd cmd) {
        ActivityEntity entity = activityGateWay.save(ActivityAssembler.toAddEntity(cmd));
        return ActivityAssembler.toActivityVO(entity);
    }
}
