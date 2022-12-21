package cn.ld.app.activity.cmd;

import cn.hutool.core.collection.CollectionUtil;
import cn.ld.app.assembler.ActivityAssembler;
import cn.ld.client.dto.cmd.ActivityAddCmd;
import cn.ld.client.dto.vo.ActivityVO;
import cn.ld.config.exception.LdException;
import cn.ld.domain.activity.ActivityEntity;
import cn.ld.domain.activityRule.ActivityRuleEntity;
import cn.ld.domain.gateway.ActivityGateWay;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
