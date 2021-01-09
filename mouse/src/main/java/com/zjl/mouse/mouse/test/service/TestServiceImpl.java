package com.zjl.mouse.mouse.test.service;

import com.alibaba.fastjson.JSONObject;
import com.zjl.mouse.mouseclient.test.vo.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.vo.res.TestResVO;
import com.zjl.mouse.mouseclient.test.service.TestService;
import com.zjl.mouse.mousedb.dao.VakaUserDAO;
import com.zjl.mouse.mousedb.model.VakaUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private VakaUserDAO vakaUserDAO;

    @Override
    public TestResVO getValue(TestReqVO testReqVO) {
        TestResVO testResVO = new TestResVO();
        VakaUser vakaUser = vakaUserDAO.selectByPrimaryKey(1L);
        testResVO.setValue("I "+testReqVO.getValue() + "|" + JSONObject.toJSONString(vakaUser) +" LIKE !!");
        return testResVO;
    }
}
