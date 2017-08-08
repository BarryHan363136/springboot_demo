package com.iris.study.springboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.iris.study.springboot.config.QuartzConfig;
import com.iris.study.springboot.entity.TaskInfo;
import com.iris.study.springboot.job.QuartzJobFactory;
import com.iris.study.springboot.mapper.TaskInfoMapper;
import com.iris.study.springboot.service.TaskService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.quartz.TriggerKey;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = LogManager.getLogger(TaskServiceImpl.class);

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private TaskInfoMapper taskInfoMapper;

    /**
     * 获取所有任务列表
     * 任务状态jobStatus: 1启用 2删除
     */
    @Override
    public List<TaskInfo> list(){
        List<TaskInfo> list = new ArrayList<TaskInfo>();
        try {
            //1.从DB中获取所有的job
            list = taskInfoMapper.findResults(null);
            if (list==null || list.isEmpty()){
                logger.warn("当前没有需要初始化启动的任务");
            }
            //2.执行job
            for (TaskInfo taskInfo : list){
                doTask(taskInfo);
            }
        } catch (Exception e) {
            logger.error("list error {} ", e);
        }
        return list;
    }

    /**
     * 保存定时任务
     * @param info
     * 2016年10月9日上午11:30:40
     */
    @Override
    public void addJob(TaskInfo info) {
        try {
            //1.新增job
        } catch (Exception e) {
            logger.error("类名不存在或执行表达式错误", e);
        }
    }

    /**
     * 修改定时任务
     * @param info
     * 2016年10月9日下午2:20:07
     */
    @Override
    public void edit(TaskInfo info) {
        try {

        } catch (Exception e) {
            logger.error("类名不存在或执行表达式错误", e);
        }
    }

    /**
     * 删除定时任务
     * @param jobName
     * @param jobGroup
     */
    @Override
    public void delete(String jobName, String jobGroup){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.pauseTrigger(triggerKey);
                scheduler.unscheduleJob(triggerKey);
                logger.info("===> delete, triggerKey:{} "+triggerKey);
            }
        } catch (SchedulerException e) {
            logger.error("delete error {} ", e);
        }
    }

    /**
     * 暂停定时任务
     * @param jobName
     * @param jobGroup
     * 2016年10月10日上午9:40:19
     */
    public void pause(String jobName, String jobGroup){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.pauseTrigger(triggerKey);
                logger.info("===> Pause success, triggerKey:{}" + triggerKey);
            }
        } catch (SchedulerException e) {
            logger.error("pause error {} ", e);
        }
    }

    /**
     * 重新开始任务
     * @param jobName
     * @param jobGroup
     * 2016年10月10日上午9:40:58
     */
    public void resume(String jobName, String jobGroup){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.resumeTrigger(triggerKey);
                logger.info("===> Resume success, triggerKey:{} " + triggerKey);
            }
        } catch (SchedulerException e) {
            logger.error("resume error {} ", e);
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

    @Override
    public String doTask(TaskInfo jobObject) {
        try {
            QuartzConfig quartzConfig = new QuartzConfig();
            Scheduler scheduler = quartzConfig.scheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(jobObject.getJobName(), jobObject.getJobGroup());
            // 获取trigger，即类似在spring配置文件中定义的 bean id="myTrigger"
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            // 不存在，创建一个
            if (trigger == null) {
                JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
                        .withIdentity(jobObject.getJobName(), jobObject.getJobGroup()).build();
                jobDetail.getJobDataMap().put("scheduleJob", jobObject);
                // 表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobObject.getCronExpression());
                // 按新的cronExpression表达式构建一个新的trigger
                trigger = TriggerBuilder.newTrigger().withIdentity(jobObject.getJobName(), jobObject.getJobGroup())
                        .withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                // Trigger已存在，根据状态更新相应的定时设置
                JobKey jobKey = JobKey.jobKey(jobObject.getJobName(), jobObject.getJobGroup());
                if ("2".equals(jobObject.getJobStatus())) {// 删除
                    if (scheduler.checkExists(triggerKey)) {// 检查是否存在，存在则删除
                        if (!scheduler.deleteJob(jobKey)) {// 删除不成功
                            logger.error("操作Task 删除 Error ，{}"+ JSON.toJSONString(jobObject));
                            return "操作Task 删除 Error ";
                        }
                    } else {
                        logger.error("操作Task 不存在 Error ，{}"+JSON.toJSONString(jobObject));
                        return "操作Task 不存在 Error";
                    }
                } else if ("1".equals(jobObject.getJobStatus())) {// 启用
                    // 表达式调度构建器
                    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                            .cronSchedule(jobObject.getCronExpression());
                    // 按新的cronExpression表达式重新构建trigger
                    trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder)
                            .build();
                    // 按新的trigger重新设置job执行
                    scheduler.rescheduleJob(triggerKey, trigger);
                    // 恢复
                    scheduler.resumeJob(jobKey);
                }
            }
            logger.info("操作Task : 【 {} 】 启动成功 "+jobObject.getJobName());
            return "success";
        } catch (Exception e) {
            logger.error("操作Task Error : {}", e);
            return "fail";
        }
    }

    /**
     * 检验时间表达式是否合法
     *
     * @param
     *            cronExpression
     * @return boolean
     */
    private boolean checkCronExpression(String cronExpression) {
        try {
            CronExpression exp = new CronExpression(cronExpression);
            SimpleDateFormat df = new SimpleDateFormat("YYYYMMDD HH:mm:ss");
            Date d = new Date();
            int i = 0;
            // 循环得到接下来n此的触发时间点，供验证
            while (i < 10) {
                d = exp.getNextValidTimeAfter(d);
                System.out.println(df.format(d));
                ++i;
            }
            return true;
        } catch (Exception e) {
            logger.error("检验时间表达式是否合法 - checkCronExpression Error : {}", e);
            return false;
        }
    }

}