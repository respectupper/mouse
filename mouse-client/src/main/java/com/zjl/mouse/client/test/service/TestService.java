package com.zjl.mouse.client.test.service;

import com.zjl.mouse.client.test.vo.res.TestResVO;
import com.zjl.mouse.client.test.vo.req.TestReqVO;

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
