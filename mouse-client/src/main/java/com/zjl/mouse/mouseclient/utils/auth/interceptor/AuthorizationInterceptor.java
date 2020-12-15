package com.zjl.mouse.mouseclient.utils.auth.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.zjl.mouse.mouseclient.utils.auth.annotation.CheckAuth;
import com.zjl.mouse.mouseclient.utils.auth.model.ReturnModel;
import com.zjl.mouse.mouseclient.utils.auth.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class AuthorizationInterceptor implements AsyncHandlerInterceptor {

    public static final String USER_KEY = "USER_ID";
    public static final String USER_INFO = "USER_INFO";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        CheckAuth annotation;
        if(handler instanceof HandlerMethod){
            annotation = ((HandlerMethod) handler).getMethodAnnotation(CheckAuth.class);
        }else {
            return true;
        }
        //没有声明需要权限,或者声明不验证权限
        if(annotation == null || annotation.isCheck() == false){
            return true;
        }
        //从header中获取token
        String token = request.getHeader("token");
        //设置编码格式防乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if(token == null){
            PrintWriter writer = response.getWriter();
            ReturnModel returnModel = new ReturnModel();
            returnModel.setCode(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
            returnModel.setMessage("接口未授权");
            writer.print(JSONObject.toJSONString(returnModel));
            return false;
        }

        //查询token信息
        //TODO 这个地方需要改成所保存的redis的token
//        boolean checkAuth = "123456".equals(token);
        boolean checkAuth = true;
        if(!checkAuth){
            PrintWriter writer = response.getWriter();
            ReturnModel returnModel = new ReturnModel();
            returnModel.setCode(HttpStatus.UNAUTHORIZED.value());
            returnModel.setMessage("token已失效");
            writer.print(JSONObject.toJSONString(returnModel));
            return false;
        }

        request.setAttribute(USER_KEY, "123456");
        UserModel user = new UserModel();
        user.setToken(token);
        request.setAttribute(USER_INFO, user);
        return true;
    }
}
