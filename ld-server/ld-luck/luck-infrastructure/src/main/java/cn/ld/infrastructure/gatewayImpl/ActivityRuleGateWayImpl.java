package cn.ld.infrastructure.gatewayImpl;

import cn.hutool.core.collection.CollectionUtil;
import cn.ld.client.dto.query.ActivityRuleListQuery;
import cn.ld.config.enums.LdExceptionEnum;
import cn.ld.config.util.Assertutil;
import cn.ld.domain.activityRule.ActivityRuleEntity;
import cn.ld.domain.gateway.ActivityRuleGateWay;
import cn.ld.infrastructure.convertor.ActivityRuleConvertor;
import cn.ld.infrastructure.database.dataObject.ActivityRuleDB;
import cn.ld.infrastructure.database.mapper.ActivityRuleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 19:58
 */
@Component
@AllArgsConstructor
public class ActivityRuleGateWayImpl implements ActivityRuleGateWay {

    private final ActivityRuleMapper activityRuleMapper;

    @Override
    public ActivityRuleEntity save(ActivityRuleEntity entity) {
        ActivityRuleDB ruleDB = ActivityRuleConvertor.toDB(entity);
        Assertutil.isTrue(activityRuleMapper.insert(ruleDB)!=1, LdExceptionEnum.ADD_ERROR.getDescription());
        return ActivityRuleConvertor.toEntity(ruleDB);
    }

    @Override
    public List<ActivityRuleEntity> list(ActivityRuleListQuery query) {
        QueryWrapper<ActivityRuleDB> wrapper = new QueryWrapper<>();
        wrapper.eq("activity_id",query.getActivityId());
        List<ActivityRuleDB> ruleDBS = activityRuleMapper.selectList(wrapper);
        if (CollectionUtil.isEmpty(ruleDBS)){
            return new ArrayList<>();
        }
        return ruleDBS.stream()
                .map(ActivityRuleConvertor::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long activityId) {
        QueryWrapper<ActivityRuleDB> wrapper = new QueryWrapper<>();
        wrapper.eq("activity_id",activityId);
        Assertutil.isTrue(activityRuleMapper.delete(wrapper)!=1,LdExceptionEnum.DELETE_ERROR.getDescription());
    }
}
