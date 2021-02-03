package com.zjl.mouse.mouseclient.test.res;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OssVo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Long fId;

    private String fName;

    private String fUrl;

    private String fBucket;

    private String isFolder;

    private String isDelete;

    private String createDate;

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
        this.fName = fName;
    }

    public String getfUrl() {
        return fUrl;
    }

    public void setfUrl(String fUrl) {
        this.fUrl = fUrl;
    }

    public String getfBucket() {
        return fBucket;
    }

    public void setfBucket(String fBucket) {
        this.fBucket = fBucket;
    }

    public String getIsFolder() {
        return isFolder;
    }

    public void setIsFolder(String isFolder) {
        this.isFolder = isFolder;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.createDate = simpleDateFormat.format(createDate);
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }
}
