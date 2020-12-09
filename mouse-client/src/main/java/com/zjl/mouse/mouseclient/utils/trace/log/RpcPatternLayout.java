package com.zjl.mouse.mouseclient.utils.trace.log;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.helpers.PatternParser;

public class RpcPatternLayout extends PatternLayout {
    public RpcPatternLayout() {
        this("%m%n");
    }

    public RpcPatternLayout(String pattern) {
        super(pattern);
    }

    public PatternParser createPatternParser(String pattern) {
        return new RpcPatternParser(pattern == null ? "%m%n" : pattern);
    }
}
