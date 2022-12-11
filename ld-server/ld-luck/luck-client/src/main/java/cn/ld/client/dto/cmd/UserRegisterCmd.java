package cn.ld.client.dto.cmd;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author mojo
 * @description: 用户注册 请求   cmd包下是修改相关的请求
 * @date 2022/12/11 0011 19:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserRegisterCmd extends Command {

    /**
     * 账号
     */
    @NotNull(message = "账号不为空")
    private String username;

    @NotNull(message = "密码不为空")
    private String password;

    /**
     * 姓名
     */
    @NotNull(message = "姓名不为空")
    private String name;

    /**
     * 电话
     */
    @NotNull(message = "电话不为空")
    private String phone;
}
