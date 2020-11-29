package com.zjl.mouse.mouseclient.utils;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *切面打印出入参
 */
public class LogInterceptor {
    /**
     * 入参数列表
     */
    private Object[] afterParam;
    /**
     * 出参数列表
     */
    private Object beforeParam;

    /**
     * 环绕执行
     * @param proceedingJoinPoint
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        /** 赋值 */
        afterParam = proceedingJoinPoint.getArgs();
        beforeParam = proceedingJoinPoint.proceed();
        /** 打印 */
        printAfterParam();
        printBeforeParam();
        return beforeParam;
    }

    /**
     * 打印入参数列表
     */
    private void printAfterParam(){
        if(afterParam!=null && afterParam.length == 1){
            if(afterParam[0]==null){
                System.out.println("null");
            }else {
                System.out.println("入参:");
                System.out.println(JSONObject.toJSONString(afterParam[0]));
            }
        }else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            for (int i = 0; i < afterParam.length; i++){
                Object param = afterParam[i];
                if(param == null){
                    stringBuilder.append(" null ");
                }
                if(afterParam.equals(i != afterParam.length-1)){
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("}");
            System.out.println("入参:");
            System.out.println(stringBuilder.toString());
        }
    }

    /**
     * 打印出参数列表
     */
    private void printBeforeParam(){
        System.out.println("出参:");
        if(beforeParam==null){
            System.out.println("null");
        }else {
            String beforeJson = JSONObject.toJSONString(beforeParam);
            JSONObject beforeObject = JSONObject.parseObject(beforeJson);
            if(beforeObject.getString("body") == null){
                System.out.println(beforeJson);
            }else {
                System.out.println(beforeObject.getString("body"));
            }
        }
    }
}
