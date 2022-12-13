package cn.ld.app.user.command;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.app.assembler.UserAssembler;
import cn.ld.client.dto.cmd.UserRegisterCmd;
import cn.ld.client.dto.data.UserVO;
import cn.ld.domain.gateway.UserGateway;
import cn.ld.domain.user.UserEntity;
import com.alibaba.cola.exception.SysException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: 用户注册 执行器
 * @date 2022/12/11 0011 22:26
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserRegisterCmdExe {

    /**
     * 调用防腐层接口
     */
    private final UserGateway userGateway;

    /**
     * 用户注册
     */
    public UserVO execute(UserRegisterCmd cmd){
        //根据账号校验用户是否存在
        UserEntity oldEntity = userGateway.getByUsername(null,cmd.getUsername());
        if (ObjectUtil.isNotNull(oldEntity)){
            throw new SysException("账号已存在");
        }
        //注册
        UserEntity entity = UserAssembler.cmdToEntity(cmd);
        UserEntity userEntity = userGateway.save(entity);
        return UserAssembler.toUserVO(userEntity);
    }
}
