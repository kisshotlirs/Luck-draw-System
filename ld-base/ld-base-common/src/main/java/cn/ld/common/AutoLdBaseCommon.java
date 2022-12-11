package cn.ld.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 使用自动装配
 * @author mojo
 */
@Configuration
@ComponentScan(basePackages = {"cn.ld.common","cn.ld.config"})
public class AutoLdBaseCommon {

}
