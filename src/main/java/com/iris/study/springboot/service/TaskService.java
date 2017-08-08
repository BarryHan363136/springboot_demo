package com.iris.study.springboot.service;

import com.iris.study.springboot.entity.TaskInfo;

import java.util.List;

public interface TaskService {

    public List<TaskInfo> getTaskList();

    public void addTask(TaskInfo info);

    public void editTask(TaskInfo info);

    public void deleteTask(String jobName, String jobGroup);

}
