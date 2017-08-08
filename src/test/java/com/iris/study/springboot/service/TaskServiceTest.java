package com.iris.study.springboot.service;

import com.iris.study.springboot.base.BaseTest;
import com.iris.study.springboot.entity.TaskInfo;
import com.iris.study.springboot.mapper.TaskInfoMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskServiceTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceTest.class);

    @Autowired
    private TaskInfoMapper taskInfoMapper;

    @Autowired
    private TaskService taskService;

    @Test
    public void testFindTasks(){
        List<TaskInfo> list = taskInfoMapper.findResults(null);
        for (TaskInfo taskInfo : list){
            logger.info("=======================>"+taskInfo.getJobGroup());
            logger.info("=======================>"+taskInfo.getJobName());
            logger.info("=======================>"+taskInfo.getCronExpression());
        }
    }

    @Test
    public void testDoTask(){
        List<TaskInfo> list = taskInfoMapper.findResults(null);
        for (TaskInfo taskInfo : list){
        }
    }

}
