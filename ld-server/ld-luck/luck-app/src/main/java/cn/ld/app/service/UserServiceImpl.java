package cn.ld.app.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.ld.app.user.cmd.UserRegisterCmdExe;
import cn.ld.app.user.cmd.UserUpdateCmdExe;
import cn.ld.app.user.query.UserListByParamQueryExe;
import cn.ld.app.user.query.UserLoginQueryExe;
import cn.ld.client.api.UserService;
import cn.ld.client.dto.cmd.UserRegisterCmd;
import cn.ld.client.dto.cmd.UserUpdateCmd;
import cn.ld.client.dto.vo.UserVO;
import cn.ld.client.dto.query.UserListByParamQuery;
import cn.ld.client.dto.query.UserLoginQuery;
import cn.ld.config.exception.LdException;
import cn.ld.config.util.JwtUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    private final UserLoginQueryExe userLoginQueryExe;

    private final UserListByParamQueryExe userListByParamQueryExe;

    private final UserUpdateCmdExe userUpdateCmdExe;

    /**
     * 用户注册
     */
    @Override
    public UserVO register(UserRegisterCmd cmd) {
        return userRegisterCmdExe.execute(cmd);
    }

    /**
     * 用户登录
     * @return token
     */
    @Override
    public String login(UserLoginQuery query) {
        UserVO userVO = userLoginQueryExe.execute(query);
        //使用jwt生成token返回给页面
        return JwtUtil.createToken(Map.of("username",userVO.getUsername(),"name", userVO.getName(), "phone", userVO.getPhone()));
    }

    /**
     * 用户分页查询
     */
    @Override
    public IPage<UserVO> page(UserListByParamQuery query) {
        return userListByParamQueryExe.execute(query);
    }

    /**
     * 根据id获取用户
     */
    @Override
    public UserVO getOne(Long id) {
        UserListByParamQuery query = new UserListByParamQuery();
        query.setId(id);
        IPage<UserVO> page = userListByParamQueryExe.execute(query);
        if (CollectionUtil.isEmpty(page.getRecords())){
            throw new LdException("该用户不存在");
        }
        return page.getRecords().get(0);
    }

    /**
     * 修改用户
     */
    @Override
    public UserVO update(UserUpdateCmd cmd) {
        return userUpdateCmdExe.execute(cmd);
    }
}
