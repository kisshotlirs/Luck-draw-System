package cn.ld.domain.gateway;

import cn.ld.client.dto.query.UserListByParamQuery;
import cn.ld.domain.user.UserEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author mojo
 * @description: 用户防腐层 接口
 * @date 2022/12/12 0012 12:36
 */
public interface UserGateway {

    /**
     * 保存用户
     */
    UserEntity save(UserEntity entity);

    /**
     * 校验用户是否存在
     */
    UserEntity getByUsername(Long id, String username);

    /**
     * 用户分页查询
     */
    IPage<UserEntity> listByQuery(UserListByParamQuery query);
}
