package cn.ld.app.activityConfig.cmd;

import cn.ld.client.dto.cmd.ActivityConfigAddCmd;
import cn.ld.client.dto.vo.ActivityConfigVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 15:15
 */
@Component
@AllArgsConstructor
public class ActivityConfigAddCmdExe {
    public ActivityConfigVO execute(ActivityConfigAddCmd cmd) {
        return null;
    }
}
