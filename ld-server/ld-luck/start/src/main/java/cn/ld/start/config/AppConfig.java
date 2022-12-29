package cn.ld.start.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/29 0029 19:49
 */
@Configuration
@EnableScheduling
@ComponentScan("cn.ld")
@MapperScan("cn.ld.infrastructure.database.mapper")
@EnableTransactionManagement
public class AppConfig {
}
