package com.zjl.mouse.mousedb.model;

import java.util.Date;

public class VakaOss {
    private Long fId;

    private String fName;

    private String fUrl;

    private String fBucket;

    private String isFolder;

    private String isDelete;

    private Date createDate;

    private String createUser;

    private String serverPath;

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public String getfUrl() {
        return fUrl;
    }

    public void setfUrl(String fUrl) {
        this.fUrl = fUrl == null ? null : fUrl.trim();
    }

    public String getfBucket() {
        return fBucket;
    }

    public void setfBucket(String fBucket) {
        this.fBucket = fBucket == null ? null : fBucket.trim();
    }

    public String getIsFolder() {
        return isFolder;
    }

    public void setIsFolder(String isFolder) {
        this.isFolder = isFolder == null ? null : isFolder.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath == null ? null : serverPath.trim();
    }
}