package com.zjl.mouse.mouseclient.utils.trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhujinglei
 */
public class TraceRecord {
    private final String error = "ERROR";
    private static Logger logger = LoggerFactory.getLogger(TraceRecord.class);
    private final String format = "[TraceLog]-[{}]-[请求={}.{}]-[服务类型={}]-[服务名={}]-[traceID={}]-[spanID={}]-[耗时={}]-[referenceId={}]\n {}";

    public TraceRecord() {
    }

    public void record(TraceRecordDTO dto) {
        this.record(dto.getLevel(), "[TraceLog]-[{}]-[请求={}.{}]-[服务类型={}]-[服务名={}]-[traceID={}]-[spanID={}]-[耗时={}]-[referenceId={}]\n {}", new Object[]{dto.getRecordType(), dto.getClientGroup(), dto.getClientIp(), dto.getProtocol(), dto.getServerName(), dto.getRecordId(), dto.getSpanId(), dto.getCost(), dto.getReferenceId(), dto.getRecordInfo()});
    }

    protected Logger getLogger() {
        return logger;
    }

    protected void record(String level, String format, Object[] obj) {
        if (error.equals(level)) {
            this.getLogger().error(format, obj);
        } else {
            this.getLogger().info(format, obj);
        }

    }
}
