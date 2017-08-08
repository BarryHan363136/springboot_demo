package com.iris.study.springboot.job;

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
 * @author chongwenjun
 *
 */
@DisallowConcurrentExecution
public class QuartzJobFactory implements Job, Serializable {

	private static final long serialVersionUID = 1L;

	/** 日志类 */
	protected final Logger logger = LoggerFactory.getLogger(super.getClass());

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		logger.info("QuartzJobFactory execute ...");
	}

}
