package com.zjl.mouse.mouserestful.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjl.mouse.mouseclient.test.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.res.TestResVO;
import com.zjl.mouse.mouseclient.utils.auth.annotation.CheckAuth;
import com.zjl.mouse.mouseclient.utils.auth.annotation.CurrentUserModel;
import com.zjl.mouse.mouseclient.utils.auth.model.UserModel;
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

    @CheckAuth
    @RequestMapping(value = "/getValue", method = RequestMethod.POST)
    String getValue(@RequestBody TestReqVO testReqVO, @CurrentUserModel UserModel userModel){
        logger.info("TestReqVO:{}",JSONObject.toJSONString(testReqVO));
        logger.info("TestReqVO:{}",JSONObject.toJSONString(userModel));
        TestResVO value = testService.test(testReqVO);
        return JSONObject.toJSONString(value);
    }

    @CheckAuth( isCheck = false)
    @RequestMapping(value = "/getValueNotNeedAuth", method = RequestMethod.POST)
    String getValueNotNeedAuth(@RequestBody TestReqVO testReqVO, @CurrentUserModel UserModel userModel){
        logger.info("TestReqVO:{}",JSONObject.toJSONString(testReqVO));
        logger.info("TestReqVO:{}",JSONObject.toJSONString(userModel));
        TestResVO value = testService.test(testReqVO);
        return JSONObject.toJSONString(value);
    }
}
