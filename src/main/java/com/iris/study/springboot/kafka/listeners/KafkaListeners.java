package com.iris.study.springboot.kafka.listeners;

import com.iris.study.springboot.common.parse.JSONMapper;
import com.iris.study.springboot.entity.Contact;
import com.iris.study.springboot.mapper.ContactMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KafkaListeners {

    private static final Logger logger = LoggerFactory.getLogger(KafkaListeners.class);

    @Autowired
    private ContactMapper contactMapper;

    @KafkaListener(topics = {"iris-test-topic"})
    public void testListener(ConsumerRecord<?, ?> record) {
        long startTime = System.currentTimeMillis();
        logger.info("<===========客户端开始接收数据========================>");
        Optional<?> messages = Optional.ofNullable(record.value());
        if (messages.isPresent()) {
            String receive = (String) messages.get();
            logger.info("  this is the testTopic send message: " + receive);
            Contact contact = (Contact) JSONMapper.fromJson(receive, Contact.class);
            performBusiness(contact);
        }
        long endTime = System.currentTimeMillis();
        logger.info("<===========客户端接收数据结束:"+(endTime-startTime));
    }

    private void performBusiness(Contact contact){
        ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.submit(new Runnable() {
                public void run() {
                    contactMapper.insert(contact);
                }
            });
    }

}
