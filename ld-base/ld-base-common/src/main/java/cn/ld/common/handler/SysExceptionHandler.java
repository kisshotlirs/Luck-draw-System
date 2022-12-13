package cn.ld.common.handler;

import cn.ld.config.exception.AuthException;
import cn.ld.config.exception.ldException;
import cn.ld.config.vo.FailInfo;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * @author mojo
 * @description: 全局异常处理器
 * @date 2022/12/10 0010 18:05
 */
@Slf4j
@RestControllerAdvice
public class SysExceptionHandler {

    /**
     * 最大的兜底错误处理
     */
    @ExceptionHandler(value = Exception.class)
    public FailInfo exception(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        return FailInfo.builder().exception(ex.getMessage()).build();
    }

    /**
     * 参数绑定错误
     */
    @ExceptionHandler(value = BindException.class)
    public FailInfo exception(BindException ex) {
        String defaultMessage = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        log.error("Exception_info:{}", defaultMessage);
        log.error("Exception_info:", ex);
        return FailInfo.builder().exception(defaultMessage).build();
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(value = ldException.class)
    public FailInfo sysException(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        return FailInfo.builder().exception(ex.getMessage()).build();
    }

    @ExceptionHandler(value = MysqlDataTruncation.class)
    public FailInfo mysqlDataTruncation(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        return new FailInfo(500, ex.getMessage());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public FailInfo dataIntegrityViolationException(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        String message = ex.getMessage();
        String[] split = message.split("\r\n###");
        for (String str : split) {
            if (str.trim().isBlank() || str.trim().contains("Error")){
                continue;
            }
            String[] split1 = str.split(":");
            if (split1.length > 0) {
                message = split1[split1.length - 1].trim();
            }
        }
        return new FailInfo(500, message);
    }

    /**
     * 权限认证异常
     */
    @ExceptionHandler(value = AuthException.class)
    public FailInfo authException(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        return FailInfo.builder().exception(ex.getMessage()).build();
    }

}
