package cn.ld.infrastructure.database.mapper;

import cn.ld.infrastructure.database.dataObject.UserDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【ld_user】的数据库操作Mapper
* @createDate 2022-12-11 17:29:39
* @Entity cn.ld.user.po.User
*/
public interface UserMapper extends BaseMapper<UserDB> {

    /**
     * 校验用户是否存在
     */
    UserDB getByName(@Param("id") Long id,@Param("username") String username);
}




