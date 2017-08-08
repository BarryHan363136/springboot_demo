package com.iris.study.springboot.entity;

import java.util.Date;

public class TaskInfo {
	private String id;

	private String jobName;

	private String jobGroup;

	private String jobStatus;

	private String cronExpression;

	private String jobDescription;

	private String jobTodourl;

	private Long createBy;

	private Date createTime;

	private Long updateBy;

	private Date updateTime;

	private String isDeleted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName == null ? null : jobName.trim();
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup == null ? null : jobGroup.trim();
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus == null ? null : jobStatus.trim();
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression == null ? null : cronExpression.trim();
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription == null ? null : jobDescription.trim();
	}

	public String getJobTodourl() {
		return jobTodourl;
	}

	public void setJobTodourl(String jobTodourl) {
		this.jobTodourl = jobTodourl == null ? null : jobTodourl.trim();
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted == null ? null : isDeleted.trim();
	}
}