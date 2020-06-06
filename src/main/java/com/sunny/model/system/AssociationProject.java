package com.sunny.model.system;

import java.util.Date;

public class AssociationProject {
    private Long projectId;

    private String projectTitle;

    private String projectTopic;

    private String projectPlace;

    private String projectWheel;

    private String sponsorTitle;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Date updateTime;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectTopic() {
        return projectTopic;
    }

    public void setProjectTopic(String projectTopic) {
        this.projectTopic = projectTopic;
    }

    public String getProjectPlace() {
        return projectPlace;
    }

    public void setProjectPlace(String projectPlace) {
        this.projectPlace = projectPlace;
    }


    public String getProjectWheel() {
		return projectWheel;
	}

	public void setProjectWheel(String projectWheel) {
		this.projectWheel = projectWheel;
	}

	public String getSponsorTitle() {
		return sponsorTitle;
	}

	public void setSponsorTitle(String sponsorTitle) {
		this.sponsorTitle = sponsorTitle;
	}

	public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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