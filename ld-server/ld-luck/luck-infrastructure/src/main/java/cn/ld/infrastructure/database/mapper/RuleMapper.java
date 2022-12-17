package cn.ld.infrastructure.database.mapper;

import cn.ld.client.dto.query.RuleListQuery;
import cn.ld.infrastructure.database.dataObject.RuleDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author mojo
* @description 针对表【ld_rule】的数据库操作Mapper
* @createDate 2022-12-11 17:31:52
* @Entity cn.ld.user.po.Rule
*/
public interface RuleMapper extends BaseMapper<RuleDB> {

    IPage<RuleDB> page(@Param("ruleDBPage") Page<RuleDB> ruleDBPage,@Param("query") RuleListQuery query);
}




