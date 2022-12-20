package cn.ld.domain.gateway;

import cn.ld.client.dto.query.ActivityListQuery;
import cn.ld.domain.activity.ActivityEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 17:07
 */
public interface ActivityGateWay {

    ActivityEntity save(ActivityEntity entity);

    IPage<ActivityEntity> page(ActivityListQuery query);
}
