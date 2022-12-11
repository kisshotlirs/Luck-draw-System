package cn.ld.domain.user;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.config.exception.ldException;
import lombok.Getter;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/11 0011 18:45
 */
@Getter
public class UserName {

    /**
     * 账号
     */
    private String username;

    public UserName(String username) {
        if (ObjectUtil.isNull(username)){
            throw new ldException("账号不能为空");
        }
        this.username = username;
    }
}
