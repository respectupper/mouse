package com.zjl.mouse.utils.restful.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

/**
 * @author zhujinglei
 * 校验token
 */
public class ExceptionReturn {
    /**
     * 方法前执行
     */
    public void after(){

    }

    /**
     * 方法后执行
     */
    public void before(){

    }

    /**
     * 环绕执行
     * @param proceedingJoinPoint
     * @return
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try{
            return proceedingJoinPoint.proceed();
        }catch (Exception e){
            HashMap map = new HashMap(2);
            map.put("code","500");
            map.put("message","系统异常");
            return new ResponseEntity(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}