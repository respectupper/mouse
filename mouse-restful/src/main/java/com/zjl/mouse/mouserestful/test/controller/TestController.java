package com.zjl.mouse.mouserestful.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjl.mouse.mouseclient.test.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.res.TestResVO;
import com.zjl.mouse.mouserestful.test.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private TestService testService;

    @RequestMapping(value = "/getValue", method = RequestMethod.POST)
    String getValue(@RequestBody TestReqVO testReqVO){
        logger.info("TestReqVO:{}",JSONObject.toJSONString(testReqVO));
        TestResVO value = testService.test(testReqVO);
        return JSONObject.toJSONString(value);
    }
}
