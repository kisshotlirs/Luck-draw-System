package cn.ld.domain.user;

import cn.hutool.crypto.digest.MD5;
import com.alibaba.cola.domain.Entity;
import lombok.Getter;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/11 0011 18:49
 */
@Getter
public class PassWord {

    private Encrypt encrypt;

    public PassWord(String password) {
        this.encrypt = new Encrypt(getEncryptPassword(password));
    }

    /**
     * 获取加密密码
     */
    private String getEncryptPassword(String password) {
        return MD5.create().digestHex(password);
    }

    @Getter
    public static class Encrypt{
        private String password;

        public Encrypt(String password) {
            this.password = password;
        }
    }

    /**
     * 判断密码是否相同
     */
    public Boolean isEqules(String password){
        return this.encrypt.password.equals(getEncryptPassword(password));
    }
}
