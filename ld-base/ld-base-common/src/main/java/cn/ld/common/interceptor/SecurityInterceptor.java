package cn.ld.common.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.ld.config.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mojo
 * @description: 拦截器 在所有服务之前截取请求头里的用户信息，放入ThreadLocal
 * @date 2022/12/15 0015 21:56
 */
@Slf4j
@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> userMap = new HashMap<>();
        //从请求头中获取用户信息  防止有中文
        String username = URLDecoder.decode(ObjectUtil.isNull(request.getHeader("username"))?"":request.getHeader("username"),"UTF-8");
        String name = URLDecoder.decode(ObjectUtil.isNull(request.getHeader("name"))?"":request.getHeader("name"),"UTF-8");
        String id = request.getHeader("id");
        String phone = request.getHeader("phone");
        userMap.put("id",id);
        userMap.put("username",username);
        userMap.put("name",name);
        userMap.put("phone",phone);

        //将用户数据保存进ThreadLocal
        SecurityUtil.addLocal(userMap);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        SecurityUtil.removeLocal();
    }
}
