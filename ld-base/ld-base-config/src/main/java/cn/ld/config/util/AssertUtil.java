package cn.ld.config.util;

import cn.ld.config.exception.LdException;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 19:47
 */
public class AssertUtil {

    public static void isTrue(Boolean expression,String message){
        if (expression){
            throw new LdException(message);
        }
    }

    public static void isFalse(Boolean expression,String message){
        if (!expression){
            throw new LdException(message);
        }
    }
}
