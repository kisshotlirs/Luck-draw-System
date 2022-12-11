package cn.ld.common.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @description: 处理结果集的自定义注解
 * @author mojo
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@RestController //组合
public @interface ResponseResult {

    /**
     * 是否忽略，默认忽略
     */
    boolean ignore() default false;
}
