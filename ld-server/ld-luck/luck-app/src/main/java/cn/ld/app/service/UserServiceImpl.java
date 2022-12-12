package cn.ld.app.service;

import cn.ld.app.user.command.UserRegisterCmdExe;
import cn.ld.client.api.UserService;
import cn.ld.client.dto.cmd.UserRegisterCmd;
import cn.ld.client.dto.cmd.UserUpdateCmd;
import cn.ld.client.dto.data.UserVO;
import cn.ld.client.dto.query.UserListByParamQuery;
import cn.ld.client.dto.query.UserLoginQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: 用户服务层 实现类
 * @date 2022/12/11 0011 21:28
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    /**
     * 构造器注入（可能的问题：循环依赖无法解决，工程师解决）
     * 高度内聚的架构
     */
    private final UserRegisterCmdExe userRegisterCmdExe;

    /**
     * 用户注册
     */
    @Override
    public UserVO register(UserRegisterCmd cmd) {
        return userRegisterCmdExe.execute(cmd);
    }

    @Override
    public UserVO login(UserLoginQuery query) {
        return null;
    }

    @Override
    public IPage<UserVO> page(UserListByParamQuery query) {
        return null;
    }

    @Override
    public UserVO getOne(Long id) {
        return null;
    }

    @Override
    public UserVO update(UserUpdateCmd cmd) {
        return null;
    }
}
