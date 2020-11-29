package com.zjl.mouse.mouserestful.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjl.mouse.mouseclient.test.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.res.TestResVO;
import com.zjl.mouse.mouseclient.test.service.TestService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping(value = "/getValue", method = RequestMethod.POST)
    String getValue(@RequestBody TestReqVO testReqVO){
        TestResVO value = testService.getValue(testReqVO);
        return JSONObject.toJSONString(value);
    }

    @RequestMapping(value = "/getListValue", method = RequestMethod.POST)
    String getListValue(@RequestBody TestReqVO testReqVO){
        TestResVO value = testService.getListValue(testReqVO);
        return JSONObject.toJSONString(value);
    }
}
