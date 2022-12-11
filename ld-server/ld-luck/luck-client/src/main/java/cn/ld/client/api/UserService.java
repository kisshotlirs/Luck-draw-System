package cn.ld.client.api;

import cn.ld.client.dto.cmd.UserRegisterCmd;
import cn.ld.client.dto.cmd.UserUpdateCmd;
import cn.ld.client.dto.data.UserVO;
import cn.ld.client.dto.query.UserListByParamQuery;
import cn.ld.client.dto.query.UserLoginQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author mojo
 * @description: 用户功能接口
 * @date 2022/12/11 0011 19:25
 */
public interface UserService {

    /**
     * 用户注册
     * @param cmd 用户注册请求
     * @return 展示对象
     */
    UserVO register(UserRegisterCmd cmd);

    /**
     * 用户登录
     * @param query 登录请求
     * @return userVO
     */
    UserVO login(UserLoginQuery query);

    /**
     * 用户分页查询
     */
    IPage<UserVO> page(UserListByParamQuery query);

    /**
     * 根据id获取用户信息
     */
    UserVO getOne(Long id);

    /**
     * 更新用户
     */
    UserVO update(UserUpdateCmd cmd);

}
