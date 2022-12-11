package cn.ld.common.handler;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.common.annotation.ResponseResult;
import cn.ld.config.vo.SuccessInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @author mojo
 * @description: 注解的处理器,针对返回结果集的处理 利用切面，结果集返回时会调用这里的方法增强
 * @date 2022/12/10 0010 16:49
 */
@Slf4j
@Component
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    /**
     * 结果集返回之前
     * 判断是否要处理结果集 ResponseBody
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //如果是文件类型的就不拦截
        if (Objects.requireNonNull(methodParameter.getMethod()).getAnnotatedReturnType().getType().getTypeName()
                .equals(FileSystemResource.class.getTypeName())){
            return false;
        }

        //判断是否增强，有 @ResponseResult注解就要处理结果集
        ResponseResult annotation = methodParameter.getClass().getAnnotation(ResponseResult.class);
        if (ObjectUtil.isNull(annotation)){
            //类上拿不到去方法上拿
            annotation = Objects.requireNonNull(methodParameter.getMethod()).getAnnotation(ResponseResult.class);
        }
        return annotation != null && !annotation.ignore();
    }

    /**
     * 结果集返回之后，处理结果集
     * 使用@SneakyThrows：抛出方法writeValueAsString的异常，减少代码冗余
     */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        //处理结果集
        var successInfo = SuccessInfo.builder()
                .data(o)
                .build();

        if (o instanceof String && !MediaType.APPLICATION_XML_VALUE.equals(mediaType.toString())){
            ObjectMapper mapper = new ObjectMapper();
            //对返回结果进行重写
            response.getHeaders().set("Content-Type","application/json");
            return mapper.writeValueAsString(successInfo);
        }

        if (ObjectUtil.isNull(o) && MediaType.TEXT_HTML_VALUE.equals(mediaType.toString())){
            ObjectMapper mapper = new ObjectMapper();
            response.getHeaders().set("Content-Type","application/json");
            return mapper.writeValueAsString(successInfo);
        }
        return successInfo;
    }
}
