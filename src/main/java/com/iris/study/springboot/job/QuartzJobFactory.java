package com.iris.study.springboot.job;

import com.iris.study.springboot.entity.TaskInfo;
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
		long currentTime = System.currentTimeMillis();
		logger.info(currentTime + " --> 开始执行任务 ", "调用 [ " + taskInfo.getJobName() + " ] 任务", taskInfo.getCronExpression(), "");

		logger.info(currentTime + " --> 一次请求所消耗的时间 ms", "调用 [ " + taskInfo.getJobName() + " ] 任务",
				String.valueOf(System.currentTimeMillis() - currentTime) + " ms", "");
	}

}
