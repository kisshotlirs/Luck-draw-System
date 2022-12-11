package cn.ld.config.exception;

/**
 * @author mojo
 * @description: 抽奖系统 自定义异常
 * @date 2022/12/10 0010 18:20
 */
public class ldException extends RuntimeException{

    public ldException() {
    }

    public ldException(String message) {
        super(message);
    }

    public ldException(String message, Throwable cause) {
        super(message, cause);
    }

    public ldException(Throwable cause) {
        super(cause);
    }

    public ldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
