package com.zjl.mouse.mouserestful.test.vo.res;

import java.util.Map;

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
}
