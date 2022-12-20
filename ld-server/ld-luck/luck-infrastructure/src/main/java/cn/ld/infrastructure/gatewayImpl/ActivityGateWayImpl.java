package cn.ld.infrastructure.gatewayImpl;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.client.dto.query.ActivityListQuery;
import cn.ld.config.exception.ldException;
import cn.ld.domain.activity.ActivityEntity;
import cn.ld.domain.gateway.ActivityGateWay;
import cn.ld.infrastructure.convertor.ActivityConvertor;
import cn.ld.infrastructure.database.dataObject.ActivityDB;
import cn.ld.infrastructure.database.mapper.ActivityMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 17:28
 */
@Component
@AllArgsConstructor
public class ActivityGateWayImpl implements ActivityGateWay {

    private final ActivityMapper activityMapper;

    @Override
    public ActivityEntity save(ActivityEntity entity) {
        if (ObjectUtil.isNull(entity.getId())){
            return addActivity(entity);
        }
        return updateActivity(entity);
    }

    private ActivityEntity addActivity(ActivityEntity entity) {
        ActivityDB activityDB = ActivityConvertor.toActivityDB(entity);
        int result = activityMapper.insert(activityDB);
        if (result!=1){
            throw new ldException("活动新建失败");
        }
        return ActivityConvertor.toEntity(activityDB);
    }

    private ActivityEntity updateActivity(ActivityEntity entity) {
        ActivityDB activityDB = ActivityConvertor.toActivityDB(entity);
        int result = activityMapper.updateById(activityDB);
        if (result!=1){
            throw new ldException("活动更新失败");
        }
        return ActivityConvertor.toEntity(activityDB);
    }

    @Override
    public IPage<ActivityEntity> page(ActivityListQuery query) {
        IPage<ActivityDB> page = activityMapper.page(new Page<ActivityDB>(query.getPageIndex(), query.getPageSize()),query);
        return page.convert(ActivityConvertor::toEntity);
    }
}
