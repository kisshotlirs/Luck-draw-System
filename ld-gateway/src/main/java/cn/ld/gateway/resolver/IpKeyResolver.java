package cn.ld.gateway.resolver;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author mojo
 * @description: 网关限流 根据配置文件
 * @date 2022/12/16 0016 19:19
 */
public class IpKeyResolver implements KeyResolver {

    /**
     * 根据ip获取信息
     */
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        //return Mono.just(exchange.getRequest().getPath().value());
        return Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostName());
    }
}
