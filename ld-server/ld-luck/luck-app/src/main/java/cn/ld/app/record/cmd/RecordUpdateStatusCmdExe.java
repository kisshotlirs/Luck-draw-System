package cn.ld.app.record.cmd;

import cn.ld.client.dto.cmd.RecordUpdateStatusCmd;
import cn.ld.config.util.AssertUtil;
import cn.ld.domain.gateway.RecordGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/30 0030 11:27
 */
@Slf4j
@Component
@AllArgsConstructor
public class RecordUpdateStatusCmdExe {

    private final RecordGateway recordGateway;

    public Boolean execute(RecordUpdateStatusCmd cmd) {
        Boolean result = recordGateway.updateStatus(cmd.getId(), cmd.getStatus());
        AssertUtil.isFalse(result,"修改记录状态失败！");
        log.info("修改记录值失败：记录id：{}，状态值：{}",cmd.getId(), cmd.getStatus());
        return result;
    }
}
