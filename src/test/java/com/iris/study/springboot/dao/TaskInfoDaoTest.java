package com.iris.study.springboot.dao;

import com.iris.study.springboot.base.BaseTest;
import com.iris.study.springboot.entity.Contact;
import com.iris.study.springboot.entity.TaskInfo;
import com.iris.study.springboot.mapper.TaskInfoMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskInfoDaoTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(TaskInfoDaoTest.class);

    @Autowired
    private TaskInfoMapper taskInfoMapper;

    @Test
    public void testFindTasks(){
        List<TaskInfo> list = taskInfoMapper.findResults(null);
        for (TaskInfo taskInfo : list){
            logger.info("=======================>"+taskInfo.getCronExpression());
        }
    }

}
