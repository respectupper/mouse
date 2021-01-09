package com.zjl.mouse.mouseclient.utils.trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TraceContext {
    private static Logger logger = LoggerFactory.getLogger(TraceContext.class);
    private static final ThreadLocal<LocalTrace> CURRENT_TRACE = new ThreadLocal();

    public TraceContext() {
    }

    private static void createCurrentTrace() {
        if (CURRENT_TRACE.get() == null) {
            CURRENT_TRACE.set(new LocalTrace());
            logger.debug("初始化currentTrace");
        }

    }

    public static void remove() {
        CURRENT_TRACE.remove();
    }

    public static void initTrace() {
        createCurrentTrace();
        if (CURRENT_TRACE.get().getTraceId() == null || CURRENT_TRACE.get().getTraceId().length() == 0) {
            Date now = new Date();
            LocalTrace localTrace = CURRENT_TRACE.get();
            localTrace.setTraceId(new SimpleDateFormat("yyyyMMdd").format(now) + "-" + UUID.randomUUID().toString().replace("-", ""));
            localTrace.setRootSpan(true);
            localTrace.setSpanId("0");
            logger.debug("初始化traceID=" + CURRENT_TRACE.get().getTraceId());
        }

    }

    public static void initTrace(String traceId, String spanId) {
        createCurrentTrace();
        CURRENT_TRACE.get().setTraceId(traceId);
        CURRENT_TRACE.get().setSpanId(spanId);
    }

    public static String getTraceId() {
        return CURRENT_TRACE.get() == null ? null : CURRENT_TRACE.get().getTraceId();
    }

    public static String getSpanId() {
        return CURRENT_TRACE.get() == null ? null : CURRENT_TRACE.get().getSpanId();
    }

    public static String getTag(String key) {
        return CURRENT_TRACE.get() == null ? null : CURRENT_TRACE.get().getTags().get(key);
    }

    public static void setTag(String key, String value) {
        CURRENT_TRACE.get().getTags().put(key, value);
    }

    public static boolean isRootSpan() {
        return CURRENT_TRACE.get().isRootSpan();
    }

    public static String initCurrSubSpanId() {
        if (CURRENT_TRACE.get() == null) {
            return null;
        } else {
            String subSpanId = CURRENT_TRACE.get().getSpanId() + "." + CURRENT_TRACE.get().getCurrSubSpanNum();
            CURRENT_TRACE.get().setCurrSubSpanId(subSpanId);
            CURRENT_TRACE.get().setCurrSubSpanNum(CURRENT_TRACE.get().getCurrSubSpanNum() + 1);
            return CURRENT_TRACE.get().getCurrSubSpanId();
        }
    }

    public static String getCurrSubSpanId() {
        return CURRENT_TRACE.get() == null ? null : CURRENT_TRACE.get().getCurrSubSpanId();
    }

    public static int getCallHierarchy() {
        return CURRENT_TRACE.get() == null ? 0 : CURRENT_TRACE.get().getCallHierarchy();
    }

    public static void increaseCallHierarch(int hierarch) {
        if (CURRENT_TRACE.get() != null) {
            CURRENT_TRACE.get().setCallHierarchy(CURRENT_TRACE.get().getCallHierarchy() + hierarch);
        }
    }

    public static boolean traced() {
        return getTraceId() != null;
    }
}
