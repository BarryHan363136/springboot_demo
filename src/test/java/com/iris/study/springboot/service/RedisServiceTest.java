package com.iris.study.springboot.service;

import com.iris.study.springboot.base.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisServiceTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisServiceTest.class);

    @Autowired
    private RedisService redisService;

    @Test
    public void testRedisSetValue(){
        boolean status = redisService.set("htb", "iris");
    }

}
