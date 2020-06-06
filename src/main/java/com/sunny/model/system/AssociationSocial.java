package com.sunny.model.system;

import java.util.Date;

public class AssociationSocial {
    private Long socialId;

    private String socialLogin;

    private String socialPassword;

    private String socialDesc;

    private Date createTime;

    private Date updateTime;

    public Long getSocialId() {
        return socialId;
    }

    public void setSocialId(Long socialId) {
        this.socialId = socialId;
    }

    public String getSocialLogin() {
        return socialLogin;
    }

    public void setSocialLogin(String socialLogin) {
        this.socialLogin = socialLogin;
    }

    public String getSocialPassword() {
        return socialPassword;
    }

    public void setSocialPassword(String socialPassword) {
        this.socialPassword = socialPassword;
    }

    public String getSocialDesc() {
        return socialDesc;
    }

    public void setSocialDesc(String socialDesc) {
        this.socialDesc = socialDesc;
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