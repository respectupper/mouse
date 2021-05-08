package com.zjl.mouse.utils.auth.model;

/**
 * @author zhujinglei
 * 该类是请求鉴权后拿到的用户数据（字段可扩展）
 */
public class UserModel {
    private Integer uid;

    private String token;

    private String mobile;

    private String username;

    private String password;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
