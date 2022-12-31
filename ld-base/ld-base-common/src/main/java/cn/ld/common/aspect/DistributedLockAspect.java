package cn.ld.common.aspect;

import cn.ld.common.annotation.DistributedLock;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/31 0031 17:41
 */
@Slf4j
@Component
@Aspect
@AllArgsConstructor
public class DistributedLockAspect {

    private final RedisTemplate<String,Object> redisTemplate;

    private static final String defaultKey = "distributed:lock:aspect:";

    @Pointcut("@annotation(cn.ld.common.annotation.DistributedLock)")
    public void distributedLock(){

    }

    @Around("distributedLock()")
    public void invoke(ProceedingJoinPoint point) throws NoSuchMethodException {

        String key = getKey(point);

        //加锁
        Boolean absent = redisTemplate.opsForValue()
                .setIfAbsent(key, Thread.currentThread().getId()+"",5, TimeUnit.MINUTES);
        if (Boolean.FALSE.equals(absent)){
            return;
        }

        //加锁成功，执行业务
        try {
            //执行业务
            point.proceed();
        } catch (Throwable e){
            log.error("业务执行出错");
        } finally {
            //资源处理
            String value = (String) redisTemplate.opsForValue().get(key);
            assert value != null;
            if (value.equals(Thread.currentThread().getId()+"")){
                //只删除自己线程加的锁，防止误删他人的锁，导致他人业务执行多次
                redisTemplate.delete(key);
            }
        }
    }

    private String getKey(ProceedingJoinPoint point){
        Method method = null;
        try {
            //获取要执行的方法对象
            method = point.getTarget()
                    .getClass()
                    .getMethod(point.getSignature().getName(),
                            ((MethodSignature) point.getSignature()).getParameterTypes());
        } catch (NoSuchMethodException e){
            log.error("获取注解key失败，使用默认key");
            return defaultKey+"default-key";
        };

        //获取注解
        DistributedLock annotation = method.getAnnotation(DistributedLock.class);
        String key = annotation.key();
        if (Objects.isNull(key)){
            key = defaultKey+method.getClass().getName()+ ":" + method.getName();
        }
        return key;
    }

}
