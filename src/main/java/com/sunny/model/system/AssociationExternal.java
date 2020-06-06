package com.sunny.model.system;

import java.util.Date;

public class AssociationExternal {
    private Long sponsorId;

    private String sponsorName;

    private Date singTime;

    private Long sponsorMoney;

    private Date createTime;

    private Date updateTime;

    public Long getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(Long sponsorId) {
        this.sponsorId = sponsorId;
    }



    public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public Date getSingTime() {
        return singTime;
    }

    public void setSingTime(Date singTime) {
        this.singTime = singTime;
    }

    public Long getSponsorMoney() {
        return sponsorMoney;
    }

    public void setSponsorMoney(Long sponsorMoney) {
        this.sponsorMoney = sponsorMoney;
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