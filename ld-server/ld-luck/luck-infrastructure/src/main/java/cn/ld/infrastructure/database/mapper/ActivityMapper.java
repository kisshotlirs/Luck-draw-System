package cn.ld.infrastructure.database.mapper;

import cn.ld.client.dto.query.ActivityListQuery;
import cn.ld.infrastructure.database.dataObject.ActivityDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【ld_activity】的数据库操作Mapper
* @createDate 2022-12-11 17:33:24
* @Entity cn.ld.user.po.Activity
*/
public interface ActivityMapper extends BaseMapper<ActivityDB> {

    IPage<ActivityDB> page(@Param("activityDBPage") Page<ActivityDB> activityDBPage,@Param("query") ActivityListQuery query);
}




