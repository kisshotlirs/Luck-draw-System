package cn.ld.domain.gateway;

import cn.ld.client.dto.query.ActivityRuleListQuery;
import cn.ld.domain.activityRule.ActivityRuleEntity;

import java.util.List;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 18:13
 */
public interface ActivityRuleGateWay {

    ActivityRuleEntity save(ActivityRuleEntity entity);

    List<ActivityRuleEntity> list(ActivityRuleListQuery query);

    void delete(Long activityId);
}
