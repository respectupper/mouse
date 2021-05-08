package com.zjl.mouse.utils.trace;

/**
 * @author zhujinglei
 */
public class TraceRecordDTO {
    public String level;
    public String recordType;
    public String recordId;
    public String recordInfo;
    /**---------------以上继承------------------*/
    public String protocol;
    public String clientIp;
    public String clientGroup;
    public String serverName;
    public String spanId;
    public long cost;
    public String referenceId;

    public TraceRecordDTO(String level, String recordType, String protocol, String clientIp, String clientGroup, String serverName, String recordId, String spanId, long cost, String recordInfo, String referenceId) {
        this.level = level;
        this.recordType = recordType;
        this.protocol = protocol;
        this.clientIp = clientIp;
        this.clientGroup = clientGroup;
        this.serverName = serverName;
        this.recordId = recordId;
        this.spanId = spanId;
        this.cost = cost;
        this.recordInfo = recordInfo;
        this.referenceId = referenceId;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientGroup() {
        return this.clientGroup;
    }

    public void setClientGroup(String clientGroup) {
        this.clientGroup = clientGroup;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public long getCost() {
        return this.cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getSpanId() {
        return this.spanId;
    }

    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRecordInfo() {
        return recordInfo;
    }

    public void setRecordInfo(String recordInfo) {
        this.recordInfo = recordInfo;
    }

    @Override
    public String toString() {
        return "TraceRecordDTO{" +
                "level='" + level + '\'' +
                ", recordType='" + recordType + '\'' +
                ", recordId='" + recordId + '\'' +
                ", recordInfo='" + recordInfo + '\'' +
                ", protocol='" + protocol + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", clientGroup='" + clientGroup + '\'' +
                ", serverName='" + serverName + '\'' +
                ", spanId='" + spanId + '\'' +
                ", cost=" + cost +
                ", referenceId='" + referenceId + '\'' +
                '}';
    }
}
