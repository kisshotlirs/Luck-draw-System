package cn.ld.client.dto.cmd;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author mojo
 * @description: 用户更新请求
 * @date 2022/12/11 0011 20:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserUpdateCmd extends Command {

    @NotNull(message = "账号不为空")
    private Long id;

    /**
     * 账号
     */
    @NotNull(message = "账号不为空")
    private String username;

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
