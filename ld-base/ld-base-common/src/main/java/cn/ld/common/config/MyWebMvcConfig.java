package cn.ld.common.config;

import cn.ld.common.interceptor.SecurityInterceptor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mojo
 * @description: 配置拦截器
 * @date 2022/12/15 0015 21:56
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class MyWebMvcConfig implements WebMvcConfigurer {

    private final SecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login", "/**/register");
    }
}
