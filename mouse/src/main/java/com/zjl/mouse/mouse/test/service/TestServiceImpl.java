package com.zjl.mouse.mouse.test.service;

import com.alibaba.fastjson.JSONObject;
import com.zjl.mouse.mouse.test.vo.OssList;
import com.zjl.mouse.mouseclient.test.req.TestReqVO;
import com.zjl.mouse.mouseclient.test.res.OssVo;
import com.zjl.mouse.mouseclient.test.res.TestResVO;
import com.zjl.mouse.mouseclient.test.service.TestService;
import com.zjl.mouse.mousedb.dao.VakaOssDAO;
import com.zjl.mouse.mousedb.dao.VakaUserDAO;
import com.zjl.mouse.mousedb.model.VakaOss;
import com.zjl.mouse.mousedb.model.VakaOssExample;
import com.zjl.mouse.mousedb.model.VakaUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private VakaUserDAO vakaUserDAO;
    @Resource
    private VakaOssDAO vakaOssDAO;

    @Override
    public TestResVO getValue(TestReqVO testReqVO) {
        TestResVO testResVO = new TestResVO();
        VakaUser vakaUser = vakaUserDAO.selectByPrimaryKey(1L);
        testResVO.setValue("I "+testReqVO.getValue() + "|" + JSONObject.toJSONString(vakaUser) +" LIKE !!");
        return testResVO;
    }

    @Override
    public TestResVO getListValue(TestReqVO testReqVO) {
        TestResVO testResVO = new TestResVO();
        VakaOssExample vakaOssExample = new VakaOssExample();
        List<VakaOss> vakaOssList = vakaOssDAO.selectByExample(vakaOssExample);
        testResVO.setOssVoList(JSONObject.parseArray(JSONObject.toJSONString(vakaOssList),OssVo.class));
        return testResVO;
    }
}
