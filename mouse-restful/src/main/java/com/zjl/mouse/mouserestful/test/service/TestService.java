package com.zjl.mouse.mouserestful.test.service;

import com.zjl.mouse.mouseclient.test.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.res.TestResVO;

public interface TestService {
    TestResVO test(TestReqVO testReqVO);
}
