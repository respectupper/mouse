package com.zjl.mouse.mouseclient.utils.trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TraceContext {
    private static Logger logger = LoggerFactory.getLogger(TraceContext.class);
    private static final ThreadLocal<LocalTrace> currentTrace = new ThreadLocal();

    public TraceContext() {
    }

    private static void createCurrentTrace() {
        if (currentTrace.get() == null) {
            currentTrace.set(new LocalTrace());
            logger.debug("初始化currentTrace");
        }

    }

    public static void remove() {
        currentTrace.remove();
    }

    public static void initTrace() {
        createCurrentTrace();
        if (currentTrace.get().getTraceId() == null || currentTrace.get().getTraceId().length() == 0) {
            Date now = new Date();
            LocalTrace localTrace = currentTrace.get();
            localTrace.setTraceId(new SimpleDateFormat("yyyyMMdd").format(now) + "-" + UUID.randomUUID().toString().replace("-", ""));
            localTrace.setRootSpan(true);
            localTrace  .setSpanId("0");
            logger.debug("初始化traceID=" + ((LocalTrace)currentTrace.get()).getTraceId());
        }

    }

    public static void initTrace(String traceId, String spanId) {
        createCurrentTrace();
        currentTrace.get().setTraceId(traceId);
        currentTrace.get().setSpanId(spanId);
    }

    public static String getTraceId() {
        return currentTrace.get() == null ? null : currentTrace.get().getTraceId();
    }

    public static String getSpanId() {
        return currentTrace.get() == null ? null : currentTrace.get().getSpanId();
    }

    public static String getTag(String key) {
        return currentTrace.get() == null ? null : currentTrace.get().getTags().get(key);
    }

    public static void setTag(String key, String value) {
        currentTrace.get().getTags().put(key, value);
    }

    public static boolean isRootSpan() {
        return currentTrace.get().isRootSpan();
    }

    public static String initCurrSubSpanId() {
        if (currentTrace.get() == null) {
            return null;
        } else {
            String subSpanId = currentTrace.get().getSpanId() + "." + currentTrace.get().getCurrSubSpanNum();
            currentTrace.get().setCurrSubSpanId(subSpanId);
            currentTrace.get().setCurrSubSpanNum(currentTrace.get().getCurrSubSpanNum() + 1);
            return currentTrace.get().getCurrSubSpanId();
        }
    }

    public static String getCurrSubSpanId() {
        return currentTrace.get() == null ? null : currentTrace.get().getCurrSubSpanId();
    }

    public static int getCallHierarchy() {
        return currentTrace.get() == null ? 0 : currentTrace.get().getCallHierarchy();
    }

    public static void increaseCallHierarch(int hierarch) {
        if (currentTrace.get() != null) {
            currentTrace.get().setCallHierarchy(currentTrace.get().getCallHierarchy() + hierarch);
        }
    }

    public static boolean traced() {
        return getTraceId() != null;
    }
}
