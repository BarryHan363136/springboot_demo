package com.iris.study.springboot.service;

import com.alibaba.fastjson.JSON;
import com.iris.study.springboot.base.BaseTest;
import com.iris.study.springboot.entity.TaskInfo;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

public class KafkaServiceTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(KafkaServiceTest.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private static final String testTopic = "iris-test-topic";

    @Test
    public void testSendkafkaMsg() {
        try {
            logger.info("<===============开始发送消息=======================>");
            TaskInfo taskInfo = new TaskInfo();
            taskInfo.setJobName("Task测试job");
            taskInfo.setJobGroup("JOB-GROUP-TEST");
            taskInfo.setCronExpression("0/5 * * * * ?");
            taskInfo.setJobStatus(2);
            taskInfo.setJobDescription("kafka测试job消息,主题为:iris-test-topic,内容为task实体");
            //kafkaTemplate.send(testTopic, "bootcwnao", message);
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(testTopic, JSON.toJSONString(taskInfo));
            if (future!=null){
                SendResult<String, Object> sendResult = future.get();
                if (sendResult!=null){
                    ProducerRecord producerRecord = sendResult.getProducerRecord();
                    logger.info("=================>producerRecord:"+producerRecord);
                    if (producerRecord!=null){
                        logger.info("=================>producerRecord:"+ JSON.toJSONString(producerRecord));
                    }
                    RecordMetadata recordMetadata = sendResult.getRecordMetadata();
                    logger.info("==========>recordMetadata:"+recordMetadata);
                    if (recordMetadata!=null){
                        logger.info("=================>recordMetadata:"+ JSON.toJSONString(recordMetadata));
                    }
                }
            }
            logger.info("<===============消息发送结束=======================>");
        } catch (Exception e) {
            logger.error("testSendkafkaMsg error {} ", e);
        }
    }

}
