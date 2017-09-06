package com.iris.study.springboot.job;

import com.iris.study.springboot.entity.quartz.TaskInfo;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;

/**
 * 定时任务运行工厂类
 * 
 */
@DisallowConcurrentExecution
public class QuartzJobFactory implements Job, Serializable {

	private static final Logger logger = LoggerFactory.getLogger(QuartzJobFactory.class);

	private static final long serialVersionUID = 1L;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		logger.debug("QuartzJobFactory execute ...");
		TaskInfo taskInfo = (TaskInfo) jobExecutionContext.getMergedJobDataMap().get("scheduleJob");
		executeJob(taskInfo);
	}

	private void executeJob(TaskInfo taskInfo){
		try {
			logger.info("<=========BEGIN=================>");
			logger.info("==========>jobName:"+taskInfo.getJobName()+",cromExpression:"+taskInfo.getCronExpression());
			logger.info("<=========END=================>");
		} catch (Exception e) {
			logger.error("executeJob error {} ", e);
		}
	}

}
