package cn.ld.common.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author mojo
 * @description: mapper扫描配置
 * @date 2022/12/11 0011 13:26
 */
@Slf4j
@Configuration
@MapperScan("cn.ld.*.mapper")
public class MapperScanConfig {
}
