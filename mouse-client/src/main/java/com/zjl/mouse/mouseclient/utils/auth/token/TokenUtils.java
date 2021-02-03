package com.zjl.mouse.mouseclient.utils.auth.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author zhujinglei
 */
@Component
public class TokenUtils {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /** 设置过期时间 */
    @Value("${TOKEN.EXPIRE_DATE}")
    private String expireDate;
    /** token秘钥 */
    @Value("${TOKEN.TOKEN_SECRET}")
    private String tokenSecret;
    @Value("${TOKEN.TOKEN_AUTH_TYPE}")
    private String tokenAuthType;
    @Value("${TOKEN.TOKEN_REDIS_URL}")
    private String tokenRedisUrl;

    private final String AUTH_REDIS = "REDIS";
    private final String AUTH_JWT = "JWT";

    public String getToken (Map<String,String> dataMap){

        String token = null;
        try {
            if(AUTH_REDIS.equals(tokenAuthType)){
                UUID uuid = UUID.randomUUID();
                token  = uuid.toString().replaceAll("-","");
                dataMap.put("token",token);
                ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
                valueOperations.set(tokenRedisUrl.concat("."+token),dataMap,Long.parseLong(expireDate), TimeUnit.MILLISECONDS);
                logger.info("Token REDIS加密成功，采用redis存储方式，token："+token);
                return token;
            }
            //过期时间
            Date date = new Date(System.currentTimeMillis()+Long.parseLong(expireDate));
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            //设置头部信息
            Map<String,Object> header = new HashMap<String,Object>(2);
            header.put("typ","JWT");
            header.put("alg","HmacSHA256");
            //携带username，password信息，生成签名
            JWTCreator.Builder builder = JWT.create()
                    .withHeader(header)
                    .withExpiresAt(date);
            for(String key : dataMap.keySet()){
                builder = builder.withClaim(key,dataMap.get(key));
            }
            token = builder.sign(algorithm);
            logger.info("Token JWT加密成功，采用jwt存储方式，token："+token);
        }catch (Exception e){
            logger.warn("Token warn : {}",e.getMessage());
        }
        return token;
    }

    /**
     * @desc   验证token，通过返回true
     * @params [token]需要校验的串
     **/
    public boolean check(String token){
        try {
            if(AUTH_REDIS.equals(tokenAuthType)){
                ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
                Object value = valueOperations.get(tokenRedisUrl.concat("."+token));
                if (value == null){
                    return false;
                }
                return true;
            }
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            logger.warn("Token warn : {}",e.getMessage());
        }
        return false;
    }


    /**
     * @desc   验证token，通过返回数据
     * @params [token]需要校验的串
     **/
    public Map<String,String> verify(String token){
        try {
            if(AUTH_REDIS.equals(tokenAuthType)){
                ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
                Object data = valueOperations.get(tokenRedisUrl.concat("." + token));
                if(data!=null){
                    Map<String,String> value = (Map<String, String>) valueOperations.get(tokenRedisUrl.concat("."+token));
                    return value;
                }
                return null;
            }
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> claims = jwt.getClaims();
            Map<String,String> data = new HashMap<String, String>(claims.keySet().size());
            for (String key : claims.keySet()){
                data.put(key,claims.get(key).asString());
            }
            return data;
        }catch (Exception e){
            logger.warn("Token warn : {}",e.getMessage());
        }
        return  null;
    }
}