package cn.ld.app.user.query;

import cn.ld.app.assembler.UserAssembler;
import cn.ld.client.dto.vo.UserVO;
import cn.ld.client.dto.query.UserLoginQuery;
import cn.ld.domain.gateway.UserGateway;
import cn.ld.domain.user.UserEntity;
import com.alibaba.cola.exception.SysException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author mojo
 * @description: 用户登录 执行器
 * @date 2022/12/13 0013 16:42
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserLoginQueryExe {

    private final UserGateway userGateway;

    public UserVO execute(UserLoginQuery query) {
        //根据账号查询用户
        UserEntity entity = userGateway.getByUsername(null, query.getUsername());
        if (Objects.isNull(entity)){
            throw new SysException("登陆失败，用户不存在");
        }
        //判断用户密码是否相同
        Boolean result = entity.getPassword().isEqules(query.getPassword());
        if (!result){
            throw new SysException("密码错误，登陆失败");
        }
        return UserAssembler.toUserVO(entity);
    }

}
