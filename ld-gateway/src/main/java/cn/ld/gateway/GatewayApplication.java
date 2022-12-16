package cn.ld.gateway;

import cn.ld.gateway.resolver.IpKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author mojo
 */
@SpringBootApplication
@ComponentScan("cn.ld")
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * 配置类放入容器中，bean的名字和配置内的一样
     */
    @Bean("ipKeyResolver")
    public IpKeyResolver ipKeyResolver(){
        return new IpKeyResolver();
    }

}
