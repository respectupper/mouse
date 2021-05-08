package com.zjl.mouse.client.test.vo.res;

import java.io.Serializable;

/**
 * @author zhujinglei
 */
public class TestResVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    /** 测试出参 */
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TestResVO{" +
                "value='" + value + '\'' +
                '}';
    }
}
