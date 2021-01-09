package com.zjl.mouse.mouseclient.utils.restful.base.vo;

public class ResultModel {
    private int result;
    private String message = "";
    private Object content;

    public ResultModel(int result, String message) {
        this.result = result;
        this.message = message;
    }

    public ResultModel(int result, String message, Object content) {
        this.result = result;
        this.message = message;
        this.content = content;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public static ResultModel ok(Object content){
        return new ResultModel(0,"成功",content);
    }
}