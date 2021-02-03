package com.zjl.mouse.mouserestful.test.service;

import com.zjl.mouse.mouseclient.test.vo.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.vo.res.TestResVO;
import com.zjl.mouse.mouseclient.utils.auth.model.UserModel;
import com.zjl.mouse.mouserestful.test.vo.req.TestTokenReqVO;
import com.zjl.mouse.mouserestful.test.vo.res.TestTokenResVO;

public interface TestService {
    TestResVO test(TestReqVO testReqVO);

    TestTokenResVO getToken(TestTokenReqVO testTokenReqVO);

    TestTokenResVO checkToken(TestTokenReqVO testTokenReqVO, UserModel userModel);
}
