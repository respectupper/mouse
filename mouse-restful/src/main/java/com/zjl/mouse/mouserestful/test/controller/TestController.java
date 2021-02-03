package com.zjl.mouse.mouserestful.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjl.mouse.mouseclient.test.vo.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.vo.res.TestResVO;
import com.zjl.mouse.mouseclient.utils.auth.annotation.CheckAuth;
import com.zjl.mouse.mouseclient.utils.auth.annotation.CurrentUserModel;
import com.zjl.mouse.mouseclient.utils.auth.model.UserModel;
import com.zjl.mouse.mouseclient.utils.restful.base.vo.ResultModel;
import com.zjl.mouse.mouseclient.utils.restful.base.vo.WebBaseController;
import com.zjl.mouse.mouserestful.test.service.TestService;
import com.zjl.mouse.mouserestful.test.vo.req.TestTokenReqVO;
import com.zjl.mouse.mouserestful.test.vo.res.TestTokenResVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController extends WebBaseController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private TestService testService;

    @CheckAuth
    @RequestMapping(value = "/getValueNeedAuth", method = RequestMethod.POST)
    ResponseEntity<ResultModel> getValueNeedAuth(@RequestBody TestReqVO testReqVO, @CurrentUserModel UserModel userModel){
        logger.info("TestReqVO:{}",JSONObject.toJSONString(testReqVO));
        logger.info("UserModel:{}",JSONObject.toJSONString(userModel));
        TestResVO test = testService.test(testReqVO);
        return responseEntity(test);
    }

    @CheckAuth( isCheck = false)
    @RequestMapping(value = "/getValueNotNeedAuth", method = RequestMethod.POST)
    ResponseEntity<ResultModel> getValueNotNeedAuth(@RequestBody TestReqVO testReqVO, @CurrentUserModel UserModel userModel){
        logger.info("TestReqVO:{}",JSONObject.toJSONString(testReqVO));
        logger.info("UserModel:{}",JSONObject.toJSONString(userModel));
        return responseEntity(userModel);
    }

    /**
     * token获取
     * @param testTokenReqVO
     * @return
     */
    @RequestMapping(value = "/initToken", method = RequestMethod.POST)
    ResponseEntity<ResultModel> initToken(@RequestBody TestTokenReqVO testTokenReqVO){
        logger.info("TestTokenReqVO:{}",JSONObject.toJSONString(testTokenReqVO));
        TestTokenResVO testTokenResVO = testService.getToken(testTokenReqVO);
        return responseEntity(testTokenResVO);
    }

    /**
     * token校验，数据获取
     * @param testTokenReqVO
     * @return
     */
    @CheckAuth
    @RequestMapping(value = "/checkToken", method = RequestMethod.POST)
    ResponseEntity<ResultModel> checkToken(@RequestBody TestTokenReqVO testTokenReqVO,@CurrentUserModel UserModel userModel){
        logger.info("TestTokenReqVO:{}",JSONObject.toJSONString(testTokenReqVO));
        TestTokenResVO testTokenResVO = testService.checkToken(testTokenReqVO,userModel);
        return responseEntity(testTokenResVO);
    }

    @RequestMapping(value = "/getListValue", method = RequestMethod.POST)
    String getListValue(@RequestBody TestReqVO testReqVO){
        TestResVO value = testService.getListValue(testReqVO);
        return JSONObject.toJSONString(value);
    }
}
