package com.iris.study.springboot.service;

import com.iris.study.springboot.base.BaseTest;
import com.iris.study.springboot.entity.TaskInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskServiceTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceTest.class);

    @Autowired
    private TaskService taskService;

    /**
     * 添加一个job任务
     * */
    @Test
    public void testDoTask(){
        List<TaskInfo> list = taskService.getTaskList();
        for (TaskInfo taskInfo : list){
            taskService.addJob(taskInfo);
        }
    }

    /**
     * 停止一个正在执行的定时任务
     * */
    @Test
    public void testPauseJob(){
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setJobName("Task测试job");
        taskInfo.setJobGroup("JOB-GROUP-TEST");
        taskInfo.setCronExpression("0/5 * * * * ?");
        taskInfo.setJobStatus(2);
        taskService.pauseJob(taskInfo);
    }

}
