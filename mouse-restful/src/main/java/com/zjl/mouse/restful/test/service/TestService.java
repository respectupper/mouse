package com.zjl.mouse.restful.test.service;

import com.zjl.mouse.client.test.vo.req.TestReqVO;
import com.zjl.mouse.client.test.vo.res.TestResVO;
import com.zjl.mouse.utils.auth.model.UserModel;
import com.zjl.mouse.restful.test.vo.req.TestTokenReqVO;
import com.zjl.mouse.restful.test.vo.res.TestTokenResVO;

/**
 * @author zhujinglei
 */
public interface TestService {
    /**
     * 测试方法
     * @param testReqVO
     * @return
     */
    TestResVO test(TestReqVO testReqVO);

    /**
     * token获取
     * @param testTokenReqVO
     * @return
     */
    TestTokenResVO getToken(TestTokenReqVO testTokenReqVO);

    /**
     * token校验
     * @param testTokenReqVO
     * @param userModel
     * @return
     */
    TestTokenResVO checkToken(TestTokenReqVO testTokenReqVO, UserModel userModel);
}
