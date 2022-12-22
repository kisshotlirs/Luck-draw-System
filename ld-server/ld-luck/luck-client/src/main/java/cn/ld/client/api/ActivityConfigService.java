package cn.ld.client.api;

import cn.ld.client.dto.cmd.ActivityConfigAddCmd;
import cn.ld.client.dto.cmd.ActivityConfigUpdateCmd;
import cn.ld.client.dto.vo.ActivityConfigCopyVO;
import cn.ld.client.dto.vo.ActivityConfigVO;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: 活动配置 （活动、规则、奖项、奖品）
 * @date 2022/12/20 0020 23:05
 */
@Service
public interface ActivityConfigService {

    ActivityConfigVO add(ActivityConfigAddCmd cmd);

    @Deprecated
    ActivityConfigVO update(ActivityConfigUpdateCmd cmd);

    ActivityConfigVO getOne(Long id);

    ActivityConfigCopyVO copy(Long id);
}
