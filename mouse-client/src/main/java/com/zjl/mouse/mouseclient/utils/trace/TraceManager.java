package com.zjl.mouse.mouseclient.utils.trace;

public class TraceManager {
    private TraceRecord traceRecord;

    public TraceManager() {
    }

    public TraceRecord getTraceRecord() {
        return this.traceRecord;
    }

    public void setTraceRecord(TraceRecord traceRecord) {
        this.traceRecord = traceRecord;
    }

    public void init() {
        TraceContext.initTrace();
    }

    public void init(String traceId, String spanId) {
        TraceContext.initTrace(traceId, spanId);
    }

    public void close() {
        TraceContext.remove();
    }

    public void setTag(String key, String value) {
        TraceContext.setTag(key, value);
    }

    public boolean traced() {
        return TraceContext.getTraceId() != null;
    }

    public void initSubSpan() {
        TraceContext.initCurrSubSpanId();
    }

    public int getCallHierarch() {
        return TraceContext.getCallHierarchy();
    }

    public void increaseCallHierarch(int hierarch) {
        TraceContext.increaseCallHierarch(hierarch);
    }

    public void record(String level, String type, String protocol, String clientIp, String clientGroup, String serverName, long cost, String info, String referenceId) {
        if (TraceContext.getTraceId() != null) {
            String spanId;
            if (!type.equals("Client") && !type.equals("Producer")) {
                spanId = TraceContext.getSpanId();
            } else {
                spanId = TraceContext.getCurrSubSpanId() == null ? TraceContext.getSpanId() : TraceContext.getCurrSubSpanId();
            }

            TraceRecordDto recordDto = new TraceRecordDto(level, type, protocol, clientIp, clientGroup, serverName, TraceContext.getTraceId(), spanId, cost, info, referenceId);
            this.traceRecord.record(recordDto);
        }
    }
}
