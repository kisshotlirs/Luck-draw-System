package cn.ld.config.exception;

import cn.ld.config.vo.FailInfo;
import lombok.Getter;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 22:22
 */
public class LdCodeException extends RuntimeException{

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public LdCodeException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public LdCodeException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public LdCodeException() {
    }

    public LdCodeException(String message) {
        super(message);
        this.code= FailInfo.DEFAULT_CODE;
    }

    public LdCodeException(String message, Throwable cause) {
        super(message, cause);
        this.code= FailInfo.DEFAULT_CODE;
    }

    public LdCodeException(Throwable cause) {
        super(cause);
        this.code= FailInfo.DEFAULT_CODE;
    }

    public LdCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code= FailInfo.DEFAULT_CODE;
    }
}
