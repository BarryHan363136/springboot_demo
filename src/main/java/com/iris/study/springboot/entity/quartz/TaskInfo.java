package com.iris.study.springboot.entity.quartz;

import java.io.Serializable;

/**
 * 管理定时任务
 */
public class TaskInfo implements Serializable{

	private static final long serialVersionUID = -8054692082716173379L;

	private int id;

	/**任务名称*/
	private String jobName;
	
	/**任务分组*/
	private String jobGroup;
	
	/**任务描述*/
	private String jobDescription;
	
	/**任务状态*/
	private Integer jobStatus;
	
	/**任务表达式*/
	private String cronExpression;

	/**创建时间*/
	private String createTime;

	/**更新时间*/
	private String updataTime;

	/**备注*/
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Integer getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Integer jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdataTime() {
		return updataTime;
	}

	public void setUpdataTime(String updataTime) {
		this.updataTime = updataTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}