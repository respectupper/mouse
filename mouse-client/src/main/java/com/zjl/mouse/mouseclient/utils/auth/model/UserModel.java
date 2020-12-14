package com.zjl.mouse.mouseclient.utils.auth.model;

/**
 * 该类是请求鉴权后拿到的用户数据（字段可扩展）
 */
public class UserModel {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
