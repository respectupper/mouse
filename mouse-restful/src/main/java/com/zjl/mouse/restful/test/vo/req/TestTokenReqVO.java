package com.zjl.mouse.restful.test.vo.req;

/**
 * @author zhujinglei
 */
public class TestTokenReqVO {
    private String token;
    private String mobile;
    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "TestTokenReqVO{" +
                "token='" + token + '\'' +
                ", mobile='" + mobile + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
