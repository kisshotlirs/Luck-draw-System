package cn.ld.config.util;

import cn.hutool.core.util.ObjectUtil;

import java.util.Map;

/**
 * @author mojo
 * @description: ThreadLocal存放用户数据
 * @date 2022/12/15 0015 20:03
 */
public class SecurityUtil {

    private static final ThreadLocal<Map<String,Object>> USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void addLocal(Map<String,Object> user){
        USER_THREAD_LOCAL.set(user);
    }

    public static void removeLocal(){
        USER_THREAD_LOCAL.remove();
    }

    public static String get(String key){
        Object value = USER_THREAD_LOCAL.get().get(key);
        return ObjectUtil.isEmpty(value) ? "" : value.toString();
    }

    public static String getUserName(){
        Object username = USER_THREAD_LOCAL.get().get("username");
        return ObjectUtil.isEmpty(username) ? "" : username.toString();
    }

    public static Long getUserId(){
        Object userId = USER_THREAD_LOCAL.get().get("id");
        return ObjectUtil.isEmpty(userId) ? 0L : Long.parseLong(userId.toString());
    }

    public static String getName(){
        Object name = USER_THREAD_LOCAL.get().get("name");
        return ObjectUtil.isEmpty(name) ? "" : name.toString();
    }

}
