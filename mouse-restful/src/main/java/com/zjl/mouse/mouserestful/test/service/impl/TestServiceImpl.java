package com.zjl.mouse.mouserestful.test.service.impl;

import com.zjl.mouse.mouseclient.test.vo.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.vo.res.TestResVO;
import com.zjl.mouse.mouseclient.utils.auth.model.UserModel;
import com.zjl.mouse.mouseclient.utils.auth.token.TokenUtils;
import com.zjl.mouse.mouserestful.test.service.TestService;
import com.zjl.mouse.mouserestful.test.vo.req.TestTokenReqVO;
import com.zjl.mouse.mouserestful.test.vo.res.TestTokenResVO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhujinglei
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private com.zjl.mouse.mouseclient.test.service.TestService testService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private TokenUtils tokenUtils;

    @Override
    public TestResVO test(TestReqVO testReqVO) {
        TestResVO value = testService.getValue(testReqVO);
        return value;
    }

    @Override
    public TestTokenResVO getToken(TestTokenReqVO testTokenReqVO) {
        TestTokenResVO testTokenResVO = new TestTokenResVO();
        Map<String, String> stringStringMap = new HashMap<>(3);
        stringStringMap.put("mobile",testTokenReqVO.getMobile());
        stringStringMap.put("password",testTokenReqVO.getPassword());
        stringStringMap.put("username",testTokenReqVO.getUsername());
        String token = tokenUtils.getToken(stringStringMap);
        testTokenResVO.setToken(token);
        return testTokenResVO;
    }

    @Override
    public TestTokenResVO checkToken(TestTokenReqVO testTokenReqVO, UserModel userModel) {
        TestTokenResVO testTokenResVO = new TestTokenResVO();
        Map<String, String> verify = tokenUtils.verify(userModel.getToken());
        testTokenResVO.setToken(userModel.getToken());
        testTokenResVO.setDataMap(verify);
        return testTokenResVO;
    }
}
