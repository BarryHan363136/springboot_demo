package com.iris.study.springboot.kafka.listeners;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class KafkaMessageHandler {

    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageHandler.class);

    @Autowired
    private KafkaConsumer<String, String> consumer;

    private ExecutorService executorService;

    public void execute() {
        executorService = Executors.newFixedThreadPool(3);
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            if (null != records) {
                executorService.submit(new ConsumerThread(records, consumer));
            }
        }
    }

    public void shutdown() {
        try {
            if (consumer != null) {
                consumer.close();
            }
            if (executorService != null) {
                executorService.shutdown();
            }
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                logger.info("=============>Timeout");
            }
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }


}
