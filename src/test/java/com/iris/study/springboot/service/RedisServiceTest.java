package com.iris.study.springboot.service;

import com.iris.study.springboot.base.BaseTest;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisServiceTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisServiceTest.class);

    @Autowired
    private RedisService redisService;

    @Test
    public void testRedisSet(){
        boolean status = redisService.set("htb", "iris");
        logger.info("数据存入redis,status:"+status);
        String data = (String) redisService.get("htb");
        logger.info("从redis中获取获取缓存数据,data:"+data);
        Assert.assertEquals("iris", data);
    }

    @Test
    public void testRedisHashSet(){
        redisService.hmSet("iris", "runya", "1901");
        logger.info("数据存入redis hash值");
        String data = (String) redisService.hmGet("iris", "runya");
        logger.info("从redis中获取获取HASH缓存数据,data:"+data);
    }

}
