package cn.ld.app.user.command;

import cn.ld.client.dto.cmd.UserRegisterCmd;
import cn.ld.client.dto.data.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/11 0011 22:26
 */
@Slf4j
@Component
public class UserRegisterCmdExe {

    public UserVO execute(UserRegisterCmd cmd){
        return null;
    }
}
