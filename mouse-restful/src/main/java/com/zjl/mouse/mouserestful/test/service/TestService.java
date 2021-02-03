package com.zjl.mouse.mouserestful.test.service;

import com.zjl.mouse.mouseclient.test.vo.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.vo.res.TestResVO;
import com.zjl.mouse.mouseclient.utils.auth.model.UserModel;
import com.zjl.mouse.mouserestful.test.vo.req.TestTokenReqVO;
import com.zjl.mouse.mouserestful.test.vo.res.TestTokenResVO;

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
