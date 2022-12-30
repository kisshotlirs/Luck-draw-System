package cn.ld.infrastructure.database.mapper;

import cn.ld.client.dto.query.RecordListQuery;
import cn.ld.infrastructure.database.dataObject.RecordDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【ld_record】的数据库操作Mapper
* @createDate 2022-12-11 17:32:13
* @Entity cn.ld.user.po.Record
*/
public interface RecordMapper extends BaseMapper<RecordDB> {

    IPage<RecordDB> page(@Param("recordDBPage") Page<RecordDB> recordDBPage, @Param("query") RecordListQuery query);

    Integer updateStatus(@Param("recordId") Long recordId, @Param("status") Integer status);
}




