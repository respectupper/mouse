package com.zjl.mouse.mouseclient.test.service;

import com.zjl.mouse.mouseclient.test.vo.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.vo.res.TestResVO;

import java.util.List;

public interface TestService {

    TestResVO getValue(TestReqVO testReqVO);

    TestResVO getListValue(TestReqVO testReqVO);
}
