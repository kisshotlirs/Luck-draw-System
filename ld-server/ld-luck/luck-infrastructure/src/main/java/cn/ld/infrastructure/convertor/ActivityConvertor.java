package cn.ld.infrastructure.convertor;
import cn.ld.domain.activity.ActivityTime;
import java.time.LocalDateTime;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.domain.activity.ActivityEntity;
import cn.ld.infrastructure.database.dataObject.ActivityDB;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 17:32
 */
public class ActivityConvertor {
    public static ActivityDB toActivityDB(ActivityEntity entity) {
        ActivityDB activityDB = new ActivityDB();
        if (ObjectUtil.isNotNull(entity.getId())){
            activityDB.setId(entity.getId());
        }
        activityDB.setActivityName(entity.getActivityName());
        activityDB.setStartTime(entity.getActivityTime().getStartTime());
        activityDB.setEndTime(entity.getActivityTime().getEndTime());
        activityDB.setDescribe(entity.getDescribe());
        activityDB.setCreateTime(entity.getCreateTime());
        activityDB.setCreator(entity.getCreator());
        activityDB.setUpdateTime(entity.getUpdateTime());
        activityDB.setUpdater(entity.getUpdater());
        return activityDB;
    }

    public static ActivityEntity toEntity(ActivityDB activityDB) {
        ActivityEntity entity = new ActivityEntity();
        if (ObjectUtil.isNotNull(activityDB.getId())){
            entity.setId(activityDB.getId());
        }
        entity.setActivityName(activityDB.getActivityName());
        entity.setActivityTime(new ActivityTime(activityDB.getStartTime(),activityDB.getEndTime()));
        entity.setDescribe(activityDB.getDescribe());
        entity.setCreateTime(activityDB.getCreateTime());
        entity.setCreator(activityDB.getCreator());
        entity.setUpdateTime(activityDB.getUpdateTime());
        entity.setUpdater(activityDB.getUpdater());
        return entity;
    }
}
