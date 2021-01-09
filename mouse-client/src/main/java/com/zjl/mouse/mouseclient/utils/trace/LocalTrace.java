package com.zjl.mouse.mouseclient.utils.trace;

import java.util.HashMap;
import java.util.Map;

public class LocalTrace {
    private String traceId;
    private String spanId;
    private boolean isRootSpan = false;
    private Map<String, String> tags = new HashMap();
    private int currSubSpanNum = 0;
    private String currSubSpanId;
    private int callHierarchy = 0;

    public LocalTrace() {
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getSpanId() {
        return this.spanId;
    }

    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public int getCurrSubSpanNum() {
        return this.currSubSpanNum;
    }

    public void setCurrSubSpanNum(int currSubSpanNum) {
        this.currSubSpanNum = currSubSpanNum;
    }

    public boolean isRootSpan() {
        return this.isRootSpan;
    }

    public void setRootSpan(boolean isRootSpan) {
        this.isRootSpan = isRootSpan;
    }

    public String getCurrSubSpanId() {
        return this.currSubSpanId;
    }

    public void setCurrSubSpanId(String currSubSpanId) {
        this.currSubSpanId = currSubSpanId;
    }

    public int getCallHierarchy() {
        return this.callHierarchy;
    }

    public void setCallHierarchy(int callHierarchy) {
        this.callHierarchy = callHierarchy;
    }
}
