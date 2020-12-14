package com.zjl.mouse.mouseclient.utils.restful.base.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class WebBaseController {
    /** 日志类 */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected <T> ResponseEntity responseEntity(Object res){
        return new ResponseEntity(ResultModel.ok(res), HttpStatus.OK);
    }
}