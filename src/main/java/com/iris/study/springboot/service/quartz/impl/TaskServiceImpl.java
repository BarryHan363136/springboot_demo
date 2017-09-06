package com.iris.study.springboot.service.quartz.impl;

import com.iris.study.springboot.entity.quartz.TaskInfo;
import com.iris.study.springboot.job.QuartzJobFactory;
import com.iris.study.springboot.mapper.quartz.TaskInfoMapper;
import com.iris.study.springboot.service.quartz.TaskService;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.quartz.TriggerKey;

import java.util.*;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = LogManager.getLogger(TaskServiceImpl.class);

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private TaskInfoMapper taskInfoMapper;

    /**
     * 获取数据库中所有的定时任务
     *
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
     *
     */
    @Override
    public void addJob(TaskInfo taskInfo) {
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
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
                // 按新的cronExpression表达式构建一个新的trigger
                trigger = TriggerBuilder.newTrigger().withIdentity(taskInfo.getJobName(), taskInfo.getJobGroup())
                        .withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                // Trigger已存在，那么更新相应的定时设置
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(taskInfo.getCronExpression());

                // 按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

                // 按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (Exception e) {
            logger.error("addTask error {} ", e);
        }
    }

    /**
     * 修改定时任务
     * @param taskInfo
     *
     */
    @Override
    public void editJob(TaskInfo taskInfo) {
        String jobName = taskInfo.getJobName(),
                jobGroup = taskInfo.getJobGroup(),
                cronExpression = taskInfo.getCronExpression(),
                jobDescription = taskInfo.getJobDescription(),
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

    /**
     * 获取所有计划中的任务列表
     *
     * @return
     * @throws SchedulerException
     */
    public List<TaskInfo> getAllJob() {
        List<TaskInfo> jobList = null;
        try {
            GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
            Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
            jobList = new ArrayList<TaskInfo>();
            for (JobKey jobKey : jobKeys) {
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                for (Trigger trigger : triggers) {
                    TaskInfo job = new TaskInfo();
                    job.setJobName(jobKey.getName());
                    job.setJobGroup(jobKey.getGroup());
                    job.setJobDescription("触发器:" + trigger.getKey());
                    Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                    Integer jobState = null;
                    if (StringUtils.isNotEmpty(triggerState.name())){
                        jobState = Integer.parseInt(triggerState.name());
                    }
                    job.setJobStatus(jobState);
                    if (trigger instanceof CronTrigger) {
                        CronTrigger cronTrigger = (CronTrigger) trigger;
                        String cronExpression = cronTrigger.getCronExpression();
                        job.setCronExpression(cronExpression);
                    }
                    jobList.add(job);
                }
            }
        } catch (SchedulerException e) {
            logger.error("getAllJob error {} ", e);
        }
        return jobList;
    }

    /**
     * 所有正在运行的job
     * TriggerState job状态定义如下:
     * NONE:0;NORMAL:1;PAUSED:2;COMPLETE:3;ERROR:4;BLOCKED:5
     * @return
     * @throws SchedulerException
     */
    public List<TaskInfo> getRunningJob() {
        List<TaskInfo> jobList = null;
        try {
            List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
            jobList = new ArrayList<TaskInfo>(executingJobs.size());
            for (JobExecutionContext executingJob : executingJobs) {
                TaskInfo job = new TaskInfo();
                JobDetail jobDetail = executingJob.getJobDetail();
                JobKey jobKey = jobDetail.getKey();
                Trigger trigger = executingJob.getTrigger();
                job.setJobName(jobKey.getName());
                job.setJobGroup(jobKey.getGroup());
                job.setJobDescription("触发器:" + trigger.getKey());
                Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                Integer jobState = null;
                if (StringUtils.isNotEmpty(triggerState.name())){
                    jobState = Integer.parseInt(triggerState.name());
                }
                job.setJobStatus(jobState);
                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    String cronExpression = cronTrigger.getCronExpression();
                    job.setCronExpression(cronExpression);
                }
                jobList.add(job);
            }
        } catch (SchedulerException e) {
            logger.error("getRunningJob error {} ", e);
        }
        return jobList;
    }

    /**
     * 暂停一个job
     *
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void pauseJob(TaskInfo scheduleJob) {
        try {
            if (checkExists(scheduleJob.getJobName(), scheduleJob.getJobGroup())){
                JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
                scheduler.pauseJob(jobKey);
            }else {
                throw new RuntimeException("暂停的job不存在,jobName:"+scheduleJob.getJobName()+",jobGroup:"+scheduleJob.getJobGroup());
            }
        } catch (SchedulerException e) {
            logger.error("pauseJob error {} ", e);
        }
    }

    /**
     * 恢复一个job
     *
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void resumeJob(TaskInfo scheduleJob) {
        try {
            if (checkExists(scheduleJob.getJobName(), scheduleJob.getJobGroup())) {
                JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
                scheduler.resumeJob(jobKey);
            }else {
                throw new RuntimeException("恢复的job不存在,jobName:"+scheduleJob.getJobName()+",jobGroup:"+scheduleJob.getJobGroup());
            }
        } catch (SchedulerException e) {
            logger.error("resumeJob error {} ", e);
        }
    }

    /**
     * 删除一个job
     *
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void deleteJob(TaskInfo scheduleJob) {
        try {
            if (checkExists(scheduleJob.getJobName(), scheduleJob.getJobGroup())) {
                JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
                scheduler.deleteJob(jobKey);
            }else {
                throw new RuntimeException("删除的job不存在,jobName:"+scheduleJob.getJobName()+",jobGroup:"+scheduleJob.getJobGroup());
            }
        } catch (SchedulerException e) {
            logger.error("deleteJob error {} ", e);
        }

    }

    /**
     * 立即执行job
     *
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void runAJobNow(TaskInfo scheduleJob) {
        try {
            if (checkExists(scheduleJob.getJobName(), scheduleJob.getJobGroup())) {
                JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
                scheduler.triggerJob(jobKey);
            }else {
                throw new RuntimeException("立即执行job的job不存在,jobName:"+scheduleJob.getJobName()+",jobGroup:"+scheduleJob.getJobGroup());
            }
        } catch (SchedulerException e) {
            logger.error("runAJobNow error {} ", e);
        }
    }

    /**
     * 更新job时间表达式
     *
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void updateJobCron(TaskInfo scheduleJob) {

        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());

            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());

            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            logger.error("updateJobCron error {} ", e);
        }
    }

}