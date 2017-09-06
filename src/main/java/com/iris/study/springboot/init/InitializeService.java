package com.iris.study.springboot.init;

import com.iris.study.springboot.entity.quartz.TaskInfo;
import com.iris.study.springboot.service.quartz.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@Order(value=1)
public class InitializeService implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializeService.class);

    @Value("${opts.content.Whether.start.sheduletask}")
    private boolean startFlag;

    @Autowired
    private TaskService taskService;

    @Override
    public void run(String... strings) throws Exception {
        logger.info(">>>>>>>>>>>>>>>InitializeService-服务启动执行，执行加载数据等操作 <<<<<<<<<<<<< strings:"+strings);
        if (startFlag){
            logger.info("<==========开始启用定时任务==================>");
            List<TaskInfo> list = taskService.getTaskList();
            if (list!=null && !list.isEmpty()){
                for (TaskInfo taskInfo : list){
                    taskService.addJob(taskInfo);
                }
            }else {
                logger.info("当前数据库没有要执行的定时任务!");
            }
            logger.info("<==========结束启用定时任务==================>");
        }else {
            logger.info("application.properties配置文件中未设置开始定时任务!");
        }
    }

}
