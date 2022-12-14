package cn.ld.app.user.command;

import cn.ld.app.assembler.UserAssembler;
import cn.ld.client.dto.cmd.UserUpdateCmd;
import cn.ld.client.dto.data.UserVO;
import cn.ld.domain.gateway.UserGateway;
import cn.ld.domain.user.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: 修改用户的执行器
 * @date 2022/12/13 0013 23:19
 */
@Component
@AllArgsConstructor
public class UserUpdateCmdExe {

    private final UserGateway userGateway;

    /**
     * 用户更新
     */
    public UserVO execute(UserUpdateCmd cmd) {
        UserEntity entity = UserAssembler.toUpdateEntity(cmd);
        UserEntity result = userGateway.save(entity);
        return UserAssembler.toUserVO(result);
    }
}
