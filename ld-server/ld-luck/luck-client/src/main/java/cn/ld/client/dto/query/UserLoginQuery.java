package cn.ld.client.dto.query;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author mojo
 * @description: 用户登录请求
 * @date 2022/12/11 0011 19:46
 */
@Data
public class UserLoginQuery {

    @NotNull(message = "账号不为空")
    private String username;

    @NotNull(message = "密码不为空")
    private String password;
}
