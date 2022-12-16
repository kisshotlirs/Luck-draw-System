package cn.ld.gateway.fliter;

import cn.ld.config.exception.ldException;
import cn.ld.config.util.JwtUtil;
import cn.ld.config.util.SecurityUtil;
import cn.ld.config.vo.FailInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author mojo
 * @description: 登录过滤认证
 * @date 2022/12/14 0014 21:02
 */
@Slf4j
@Component
@Order(-1)
@Data
@ConfigurationProperties(prefix = "ld.jwt-token-global-filter")
public class JwtTokenGlobalFilter implements GlobalFilter {

    private final ObjectMapper objectMapper;

    public JwtTokenGlobalFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * 认证标识
     */
    private String authorization = "Authorization";

    /**
     * 忽略认证的路径
     */
    private Set<String> ignoreUrlSet = Set.of(
            "user/login",
            "user/register"
    );

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求的url
        String url = exchange.getRequest().getURI().getPath();

        //忽略认证
        for (String ignoreUrl : ignoreUrlSet) {
            if (ignore(url,ignoreUrl)){
                return chain.filter(exchange);
            }
        }

        //认证逻辑
        String token = exchange.getRequest().getHeaders().getFirst(authorization);
        ServerHttpResponse response = exchange.getResponse();
        try {
            Map<String, Object> userMap = JwtUtil.verifyToken(token);
            //SecurityUtil.addLocal(userMap);

            //重新定义请求头，在请求头中放入用户信息
            ServerHttpRequest.Builder mutate = exchange.getRequest().mutate();
            mutate.header("name", URLEncoder.encode(Objects.isNull(userMap.get("name")) ? "" : userMap.get("name").toString()), "UTF-8");
            mutate.header("username", URLEncoder.encode(Objects.isNull(userMap.get("username")) ? "" : userMap.get("username").toString()), "UTF-8");
            mutate.header("id", Objects.isNull(userMap.get("id")) ? "0" : userMap.get("id").toString());
            mutate.header("phone", Objects.isNull(userMap.get("phone")) ? "" : userMap.get("phone").toString());

            return chain.filter(exchange);
        }catch (Exception e){
            log.error("token认证失败");
            //认证失败，写一个统一错误JSON
            return autoError(response,"用户认证出错，请重试！");
        }
    }

    /**
     * 认证失败，写一个统一错误JSON
     * @param resp 返回信息
     * @param msg 异常信息
     */
    private Mono<Void> autoError(ServerHttpResponse resp, String msg) {
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");

        String returnStr = "";
        try {
            returnStr = objectMapper.writeValueAsString(new FailInfo(msg));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        DataBuffer buffer = resp.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));

        return resp.writeWith(Flux.just(buffer));
    }

    /**
     * 忽略请求逻辑
     * @param url 请求url
     * @param ignoreUrl 忽略url
     */
    private Boolean ignore(String url,String ignoreUrl){
        if (StringUtils.isBlank(url)){
            throw new ldException("请求url有误");
        }
        return url.contains(ignoreUrl);
    }

}
