package cn.ld.config.exception;

/**
 * @author mojo
 * @description: 抽奖系统 自定义异常
 * @date 2022/12/10 0010 18:20
 */
public class LdException extends RuntimeException{

    public LdException() {
    }

    public LdException(String message) {
        super(message);
    }

    public LdException(String message, Throwable cause) {
        super(message, cause);
    }

    public LdException(Throwable cause) {
        super(cause);
    }

    public LdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
