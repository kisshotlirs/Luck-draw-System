package cn.ld.config.util;

import cn.ld.config.exception.AuthException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mojo
 * @description: jwt工具类
 * @date 2022/12/13 0013 17:18
 */
@Slf4j
public class JwtUtil {

    /**
     * 过期时间
     */
    private static final String SECRET = "luck-draw";

    /**
     * 过期时间，单位 秒，两天
     */
    public static final Long EXPIRE_TIME = 2*24*60*60L;

    /**
     * 生成用户token，设置token超时时间
     * 添加用户信息，可以放入map中
     */
    public static String createToken(Map<String,Object> params){
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        //添加头信息
        Map<String, Object> header = new HashMap<>();
        header.put("alg","HS256");
        header.put("typ","JWT");

        JWTCreator.Builder builder = JWT.create()
                .withHeader(header)
                //过期时间
                .withExpiresAt(expireDate)
                //签发时间
                .withIssuedAt(new Date());
        params.forEach((k,v) -> {
            builder.withClaim(k,v.toString());
        });
        //签名加密
        String sign = builder.sign(Algorithm.HMAC256(SECRET));
        return sign;
    }

    /**
     * 校验解析token
     */
    public static Map<String, Object> verifyToken(String token){
        DecodedJWT jwt = null;
        Map<String, Object> result = new HashMap<>();

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
            Map<String, Claim> claims = jwt.getClaims();
            result.putAll(claims);
        }catch (Exception e){
            log.error("验证token失败，verifyToken error: "+e);
            throw new AuthException(e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","zyl");
        map.put("url","www.cola.com");
        String token = createToken(map);

        System.out.println("生成的token为："+token);
        System.out.println("解析的token为："+verifyToken(token));
    }

}
