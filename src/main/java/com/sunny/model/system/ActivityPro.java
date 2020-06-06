package com.sunny.model.system;

import java.util.Date;

public class ActivityPro {
    private Long proId;

    private String proTitle;

    private String proAuthor;

    private Date proDate;

    private String proContent;

    private Date createTime;

    private Date updateTime;

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProTitle() {
        return proTitle;
    }

    public void setProTitle(String proTitle) {
        this.proTitle = proTitle;
    }

    public String getProAuthor() {
        return proAuthor;
    }

    public void setProAuthor(String proAuthor) {
        this.proAuthor = proAuthor;
    }

    public Date getProDate() {
        return proDate;
    }

    public void setProDate(Date proDate) {
        this.proDate = proDate;
    }

    public String getProContent() {
        return proContent;
    }

    public void setProContent(String proContent) {
        this.proContent = proContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}