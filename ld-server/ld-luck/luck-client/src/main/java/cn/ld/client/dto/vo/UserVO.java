package cn.ld.client.dto.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: 用户 展示给前端对象
 * @date 2022/12/11 0011 19:19
 */
@Data
public class UserVO {

    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
