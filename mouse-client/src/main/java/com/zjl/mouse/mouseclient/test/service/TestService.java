package com.zjl.mouse.mouseclient.test.service;

import com.zjl.mouse.mouseclient.test.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.res.TestResVO;

import java.util.List;

public interface TestService {

    TestResVO getValue(TestReqVO testReqVO);

    TestResVO getListValue(TestReqVO testReqVO);
}
