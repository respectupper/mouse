package com.zjl.mouse.mouseclient.test.vo.req;

import java.io.Serializable;

public class TestReqVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    /** 测试入参 */
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
