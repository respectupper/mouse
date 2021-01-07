package com.zjl.mouse.mouseclient.utils.trace.log;

import com.zjl.mouse.mouseclient.utils.trace.TraceContext;
import org.apache.log4j.helpers.FormattingInfo;
import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.helpers.PatternParser;
import org.apache.log4j.spi.LoggingEvent;

public class RpcPatternParser extends PatternParser {
    public RpcPatternParser(String pattern) {
        super(pattern);
    }

    @Override
    public void finalizeConverter(char c) {
        if (c == '#') {
            String exs = super.extractOption();
            if (exs.startsWith("trace")) {
                this.addConverter(new RpcPatternParser.TracePatternConverter(this.formattingInfo, exs));
                this.currentLiteral.setLength(0);
            } else {
                super.finalizeConverter(c);
            }
        } else {
            super.finalizeConverter(c);
        }

    }

    private class TracePatternConverter extends PatternConverter {
        TracePatternConverter(FormattingInfo formattingInfo, String exs) {
            super(formattingInfo);
        }

        @Override
        public String convert(LoggingEvent event) {
            return TraceContext.getTraceId() != null ? TraceContext.getTraceId() + "." + TraceContext.getSpanId() : "";
        }
    }
}