package com.zjl.mouse.mouseclient.test.service;

import com.zjl.mouse.mouseclient.test.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.res.TestResVO;

public interface TestService {

    TestResVO getValue(TestReqVO testReqVO);
}
