package com.zjl.mouse.mouserestful.test.service.impl;

import com.zjl.mouse.mouseclient.test.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.res.TestResVO;
import com.zjl.mouse.mouserestful.test.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private com.zjl.mouse.mouseclient.test.service.TestService testService;

    @Override
    public TestResVO test(TestReqVO testReqVO) {
        TestResVO value = testService.getValue(testReqVO);
        return value;
    }
}
