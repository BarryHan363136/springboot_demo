package com.iris.study.springboot.service;

import com.iris.study.springboot.base.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Created by hantongshan on 2017/8/9.
 */
public class KafkaServiceTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(KafkaServiceTest.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void testSendkafkaMsg() {
        Object message = null;
        kafkaTemplate.send("test-topic", message);
        kafkaTemplate.send("test-topic", "bootcwnao", message);
    }

}
