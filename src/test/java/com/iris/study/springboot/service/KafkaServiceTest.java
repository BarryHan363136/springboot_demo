package com.iris.study.springboot.service;

import com.alibaba.fastjson.JSON;
import com.iris.study.springboot.base.BaseTest;
import com.iris.study.springboot.entity.Contact;
import com.iris.study.springboot.entity.TaskInfo;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;

public class KafkaServiceTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(KafkaServiceTest.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private static final String testTopic = "iris-test-topic";

    @Ignore
    @Test
    public void testSendkafkaMsg() {
        try {
            logger.info("<===============开始发送消息=======================>");
            Contact contact = new Contact();
            contact.setId(1);
            contact.setName("张三");
            contact.setSex(1);
            contact.setAge(30);
            contact.setPhone("021-85365248");
            contact.setMobile("15868536952");
            contact.setAddress("上海市黄浦区龙华东路800号1206室");
            contact.setEmail("test@163.com");
            contact.setRemark("remark-test");
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(testTopic, JSON.toJSONString(contact));
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

    @Test
    public void testSendBatchkafkaMsg() {
        List<String> list = new ArrayList<String>();
        for (int i=1;i<100001;i++){
            Contact contact = new Contact();
            contact.setId(i);
            contact.setName("张三-"+i);
            contact.setSex(1);
            contact.setAge(30);
            contact.setPhone("021-85365248");
            contact.setMobile("15868536952");
            contact.setAddress("上海市黄浦区龙华东路800号1206室");
            contact.setEmail("test@163.com");
            contact.setRemark("remark-test");
            list.add(JSON.toJSONString(contact));
        }
        long startTime = System.currentTimeMillis();
        logger.info("<=====producer======客户端开始发送数据========================>");
        for (String jsonData : list){
            kafkaTemplate.send(testTopic, jsonData);
        }
        long endTime = System.currentTimeMillis();
        logger.info("<======producer=====客户端发送数据结束========================>发送十万条数据总耗时:"+(endTime-startTime));
    }

}
