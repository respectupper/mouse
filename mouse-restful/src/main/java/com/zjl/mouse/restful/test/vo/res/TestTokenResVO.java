package com.zjl.mouse.restful.test.vo.res;

import java.util.Map;

/**
 * @author zhujinglei
 */
public class TestTokenResVO {
    private String token;
    Map<String, String> dataMap;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, String> dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    public String toString() {
        return "TestTokenResVO{" +
                "token='" + token + '\'' +
                ", dataMap=" + dataMap +
                '}';
    }
}
