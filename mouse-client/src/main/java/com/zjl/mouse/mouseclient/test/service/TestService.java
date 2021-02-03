package com.zjl.mouse.mouseclient.test.service;

import com.zjl.mouse.mouseclient.test.vo.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.vo.res.TestResVO;

import java.util.List;

/**
 * @author zhujinglei
 */
public interface TestService {

    /**
     * 测试方法
     * @param testReqVO
     * @return
     */
    TestResVO getValue(TestReqVO testReqVO);

}
