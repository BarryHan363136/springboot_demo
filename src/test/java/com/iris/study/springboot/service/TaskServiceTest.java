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

    @Test
    public void testStartTask(){
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setJobGroup("TEST-GROUP-001");
        taskInfo.setJobName("TASK测试job");
        taskInfo.setJobDescription("JOB DES TEST EXECUTE JOB");
        taskInfo.setJobStatus(1);
    }

    @Test
    public void testDoTask(){
        List<TaskInfo> list = taskService.getTaskList();
        for (TaskInfo taskInfo : list){
            taskService.addTask(taskInfo);
        }
    }

}
