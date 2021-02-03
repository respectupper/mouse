package com.zjl.mouse.mouseclient.test.vo.res;

import java.io.Serializable;
import java.util.List;

public class TestResVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    /** 测试出参 */
    private String value;
    /** 测试出参 */
    private List<OssVo> ossVoList;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<OssVo> getOssVoList() {
        return ossVoList;
    }

    public void setOssVoList(List<OssVo> ossVoList) {
        this.ossVoList = ossVoList;
    }
}
