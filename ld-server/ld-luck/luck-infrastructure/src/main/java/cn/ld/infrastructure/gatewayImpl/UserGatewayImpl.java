package cn.ld.infrastructure.gatewayImpl;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.client.dto.query.UserListByParamQuery;
import cn.ld.domain.gateway.UserGateway;
import cn.ld.domain.user.UserEntity;
import cn.ld.infrastructure.convertor.UserConvertor;
import cn.ld.infrastructure.database.dataObject.UserDB;
import cn.ld.infrastructure.database.mapper.UserMapper;
import com.alibaba.cola.exception.SysException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/12 0012 13:09
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserMapper userMapper;

    @Override
    public UserEntity save(UserEntity entity) {
        if (ObjectUtil.isNull(entity.getId())){
            //判断为用户注册
            return addUser(entity);
        }
        //判断为 用户修改更新
        return updateUser(entity);
    }

    private UserEntity updateUser(UserEntity entity) {
        UserDB userDB = UserConvertor.toUserDB(entity);
        int result = userMapper.updateById(userDB);
        if (result<=0){
            throw new SysException("用户信息更新失败");
        }
        return UserConvertor.toUserEntity(userDB);
    }

    /**
     * 用户注册
     */
    private UserEntity addUser(UserEntity entity) {
        UserDB userDB = UserConvertor.toUserDB(entity);
        int insert = userMapper.insert(userDB);
        if (insert<=0){
            throw new SysException("用户注册失败");
        }
        return UserConvertor.toUserEntity(userDB);
    }

    @Override
    public UserEntity getByUsername(Long id, String username) {
        UserDB userDB = userMapper.getByName(id,username);
        if (ObjectUtil.isNull(userDB)){
            return null;
        }
        return UserConvertor.toUserEntity(userDB);
    }

    @Override
    public IPage<UserEntity> listByQuery(UserListByParamQuery query) {
        IPage<UserDB> userDBIPage = userMapper.listByQuery(new Page<UserEntity>(query.getPageIndex(), query.getPageSize()), query);
        return userDBIPage.convert(UserConvertor::toUserEntity);
    }
}
