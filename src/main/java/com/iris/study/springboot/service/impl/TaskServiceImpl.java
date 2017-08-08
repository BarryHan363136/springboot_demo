package com.iris.study.springboot.service.impl;

import com.iris.study.springboot.entity.TaskInfo;
import com.iris.study.springboot.job.QuartzJobFactory;
import com.iris.study.springboot.mapper.TaskInfoMapper;
import com.iris.study.springboot.service.TaskService;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.quartz.TriggerKey;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = LogManager.getLogger(TaskServiceImpl.class);

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private TaskInfoMapper taskInfoMapper;

    /**
     * 所有任务列表
     * 2016年10月9日上午11:16:59
     */
    @Override
    public List<TaskInfo> getTaskList(){
        List<TaskInfo> list = null;
        try {
            list = taskInfoMapper.findResults(null);
        } catch (Exception e) {
            list = null;
            logger.error("list error {} ", e);
        }
        return list;
    }

    /**
     * 保存定时任务
     * @param taskInfo
     * 2016年10月9日上午11:30:40
     */
    @Override
    public void addTask(TaskInfo taskInfo) {
        String jobName = taskInfo.getJobName(),
                jobGroup = taskInfo.getJobGroup(),
                cronExpression = taskInfo.getCronExpression(),
                jobDescription = taskInfo.getJobDescription(),
                createTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        try {
            if (checkExists(jobName, jobGroup)) {
                logger.info("===> AddJob fail, job already exist, jobGroup:{} "+jobGroup+" jobName:{} "+jobName);
                throw new RuntimeException(String.format("Job已经存在, jobName:{%s},jobGroup:{%s}", jobName, jobGroup));
            }
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);

            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger==null){
                JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
                        .withIdentity(taskInfo.getJobName(), taskInfo.getJobGroup()).build();
                jobDetail.getJobDataMap().put("scheduleJob", taskInfo);
                // 表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(taskInfo.getCronExpression());
                // 按新的cronExpression表达式构建一个新的trigger
                trigger = TriggerBuilder.newTrigger().withIdentity(taskInfo.getJobName(), taskInfo.getJobGroup())
                        .withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
                if (scheduler.isShutdown()){
                    scheduler.start();
                }
            }
        } catch (Exception e) {
            logger.error("addJob error {} ", e);
        }
    }

    /**
     * 修改定时任务
     * @param info
     * 2016年10月9日下午2:20:07
     */
    @Override
    public void editTask(TaskInfo info) {
        String jobName = info.getJobName(),
                jobGroup = info.getJobGroup(),
                cronExpression = info.getCronExpression(),
                jobDescription = info.getJobDescription(),
                createTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        try {
            if (!checkExists(jobName, jobGroup)) {
                throw new RuntimeException(String.format("Job不存在, jobName:{%s},jobGroup:{%s} "+jobName, jobGroup));
            }
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            JobKey jobKey = new JobKey(jobName, jobGroup);
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withDescription(createTime).withSchedule(cronScheduleBuilder).build();

            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            jobDetail.getJobBuilder().withDescription(jobDescription);
            HashSet<Trigger> triggerSet = new HashSet<>();
            triggerSet.add(cronTrigger);

            scheduler.scheduleJob(jobDetail, triggerSet, true);
        } catch (SchedulerException e) {
            logger.error("edit error {} ", e);
        }
    }

    /**
     * 删除定时任务
     * @param jobName
     * @param jobGroup
     * 2016年10月9日下午1:51:12
     */
    @Override
    public void deleteTask(String jobName, String jobGroup){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.pauseTrigger(triggerKey);
                scheduler.unscheduleJob(triggerKey);
                logger.info("===> delete, triggerKey:{} "+ triggerKey);
            }
        } catch (SchedulerException e) {
            logger.error("delete error {} ", e);
        }
    }

    /**
     * 验证是否存在
     * @param jobName
     * @param jobGroup
     * @throws SchedulerException
     * 2016年10月8日下午5:30:43
     */
    private boolean checkExists(String jobName, String jobGroup) throws SchedulerException{
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        return scheduler.checkExists(triggerKey);
    }

}