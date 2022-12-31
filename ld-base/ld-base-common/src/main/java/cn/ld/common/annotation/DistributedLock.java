package cn.ld.common.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @description 分布式锁注解
 * @author Administrator
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface DistributedLock {

    String key() default "distributedLock";
}
