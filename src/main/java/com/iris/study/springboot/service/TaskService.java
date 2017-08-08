package com.iris.study.springboot.service;

import com.iris.study.springboot.entity.TaskInfo;

import java.util.List;

public interface TaskService {

    public List<TaskInfo> list();

    public void addJob(TaskInfo info);

    public void edit(TaskInfo info);

    public void delete(String jobName, String jobGroup);

}
