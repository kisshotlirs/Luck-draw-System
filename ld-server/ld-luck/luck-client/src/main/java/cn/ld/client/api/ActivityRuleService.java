package cn.ld.client.api;

import cn.ld.client.dto.cmd.ActivityRuleAddCmd;
import cn.ld.client.dto.query.ActivityRuleListQuery;
import cn.ld.client.dto.vo.ActivityRuleVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 17:25
 */
@Service
public interface ActivityRuleService {

    ActivityRuleVO add(ActivityRuleAddCmd cmd);

    List<ActivityRuleVO> list(ActivityRuleListQuery query);
}
