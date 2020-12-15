package com.zjl.mouse.mouseclient.utils.auth.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {
    //设置过期时间
    @Value("${TOKEN.EXPIRE_DATE}")
    private String EXPIRE_DATE;
    //token秘钥
    @Value("${TOKEN.TOKEN_SECRET}")
    private String TOKEN_SECRET;

    public String getToken (Map<String,String> dataMap){

        String token = null;
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis()+Long.parseLong(EXPIRE_DATE));
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<String,Object>();
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
            e.printStackTrace();
        }
        return token;
    }

    public Map<String,String> verify(String token){
        /**
         * @desc   验证token，通过返回true
         * @params [token]需要校验的串
         **/
        Map<String,String> data = new HashMap<String, String>();
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> claims = jwt.getClaims();
            for (String key : claims.keySet()){
                data.put(key,claims.get(key).asString());
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
}