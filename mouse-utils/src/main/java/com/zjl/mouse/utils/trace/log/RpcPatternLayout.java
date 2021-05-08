package com.zjl.mouse.utils.trace.log;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.helpers.PatternParser;

/**
 * @author zhujinglei
 */
public class RpcPatternLayout extends PatternLayout {
    public RpcPatternLayout() {
        this("%m%n");
    }

    public RpcPatternLayout(String pattern) {
        super(pattern);
    }

    @Override
    public PatternParser createPatternParser(String pattern) {
        return new RpcPatternParser(pattern == null ? "%m%n" : pattern);
    }
}
