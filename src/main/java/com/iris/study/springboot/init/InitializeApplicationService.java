package com.iris.study.springboot.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(value=2)
public class InitializeApplicationService implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializeService.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info(">>>>>>>>>>>>>>>InitializeApplicationService-服务启动执行，执行加载数据等操作 args:"+args);
    }
}