package com.iris.study.springboot.service;

import com.iris.study.springboot.entity.TaskInfo;

import java.util.List;

public interface TaskService {

    /**
     * 获取数据库中所有的定时任务
     */
    public List<TaskInfo> getTaskList();

    /**
     * 保存定时任务
     * @param taskInfo
     *
     */
    public void addJob(TaskInfo taskInfo);

    /**
     * 修改定时任务
     * @param taskInfo
     *
     */
    public void editJob(TaskInfo taskInfo);

    /**
     * 获取所有计划中的任务列表
     *
     * @return
     */
    public List<TaskInfo> getAllJob();

    /**
     * 所有正在运行的job
     * @return
     */
    public List<TaskInfo> getRunningJob();

    /**
     * 暂停一个job
     */
    public void pauseJob(TaskInfo scheduleJob);

    /**
     * 恢复一个job
     */
    public void resumeJob(TaskInfo scheduleJob);

    /**
     * 删除一个job
     */
    public void deleteJob(TaskInfo scheduleJob);

    /**
     * 立即执行job
     */
    public void runAJobNow(TaskInfo scheduleJob);

    /**
     * 更新job时间表达式
     */
    public void updateJobCron(TaskInfo scheduleJob);

}
