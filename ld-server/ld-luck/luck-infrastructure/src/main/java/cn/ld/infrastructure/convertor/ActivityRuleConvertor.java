package cn.ld.infrastructure.convertor;
import java.time.LocalDateTime;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.ld.domain.activityRule.ActivityRuleEntity;
import cn.ld.infrastructure.database.dataObject.ActivityRuleDB;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 20:34
 */
public class ActivityRuleConvertor {

    public static ActivityRuleDB toDB(ActivityRuleEntity entity) {
        ActivityRuleDB ruleDB = new ActivityRuleDB();
        if (ObjectUtil.isNotNull(entity.getId())){
            ruleDB.setId(entity.getId());
        }
        ruleDB.setActivityId(entity.getActivityId());
        ruleDB.setRuleId(entity.getRuleId());
        ruleDB.setCreateTime(entity.getCreateTime());
        ruleDB.setCreator(entity.getCreator());
        ruleDB.setUpdateTime(entity.getUpdateTime());
        ruleDB.setUpdater(entity.getUpdater());
        return ruleDB;
    }

    public static ActivityRuleEntity toEntity(ActivityRuleDB ruleDB) {
        ActivityRuleEntity entity = new ActivityRuleEntity();
        if (ObjectUtil.isNotNull(ruleDB.getId())){
            entity.setId(ruleDB.getId());
        }
        entity.setActivityId(ruleDB.getActivityId());
        entity.setRuleId(ruleDB.getRuleId());
        entity.setCreateTime(ruleDB.getCreateTime());
        entity.setCreator(ruleDB.getCreator());
        entity.setUpdateTime(ruleDB.getUpdateTime());
        entity.setUpdater(ruleDB.getUpdater());
        return entity;
    }

    /*@Contract("null->false")
    public static boolean isNotNull(
    Object obj )*/
}
