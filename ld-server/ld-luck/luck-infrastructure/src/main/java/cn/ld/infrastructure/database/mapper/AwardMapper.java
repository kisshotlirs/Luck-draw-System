package cn.ld.infrastructure.database.mapper;

import cn.ld.client.dto.query.AwardListQuery;
import cn.ld.infrastructure.database.dataObject.AwardDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【ld_award】的数据库操作Mapper
* @createDate 2022-12-11 17:33:03
* @Entity cn.ld.user.po.Award
*/
public interface AwardMapper extends BaseMapper<AwardDB> {

    IPage<AwardDB> page(@Param("awardDBPage") Page<AwardDB> awardDBPage,@Param("query") AwardListQuery query);
}




