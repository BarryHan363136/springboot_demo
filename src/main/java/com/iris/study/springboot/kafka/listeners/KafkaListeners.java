package com.iris.study.springboot.kafka.listeners;

import com.alibaba.fastjson.JSON;
import com.iris.study.springboot.common.parse.JSONMapper;
import com.iris.study.springboot.entity.Contact;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Optional;

public class KafkaListeners {

    private static final Logger logger = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(topics = {"iris-test-topic"})
    public void testListener(ConsumerRecord<?, ?> record) {

        Optional<?> messages = Optional.ofNullable(record.value());

        if (messages.isPresent()) {
            String receive = (String) messages.get();
            logger.info("  this is the testTopic send message: " + receive);
            Contact contact = (Contact) JSONMapper.fromJson(receive, Contact.class);
            logger.info("============>getId:"+contact.getId());
            logger.info("============>getName:"+contact.getName());
        }
    }
}
