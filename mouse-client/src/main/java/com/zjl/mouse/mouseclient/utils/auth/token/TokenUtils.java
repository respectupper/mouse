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
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /** 设置过期时间 */
    @Value("${TOKEN.EXPIRE_DATE}")
    private String expireDate;
    /** token秘钥 */
    @Value("${TOKEN.TOKEN_SECRET}")
    private String tokenSecret;

    public String getToken (Map<String,String> dataMap){

        String token = null;
        try {
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