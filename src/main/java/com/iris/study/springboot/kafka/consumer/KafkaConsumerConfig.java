package com.iris.study.springboot.kafka.consumer;

import com.iris.study.springboot.kafka.listeners.KafkaListeners;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@Component
public class KafkaConsumerConfig {

    @Value("${kafka.binder.brokers}")
    private String brokers;//需要在application.properties中配置此属性

    @Value("${kafka.binder.group}")
    private String group;//需要在application.properties中配置此属性

    //KafkaMessageListenerContainer.ListenerConsumer

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(4);
        factory.getContainerProperties().setPollTimeout(4000);
        return factory;
    }

    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }


    public Map<String, Object> consumerConfigs() {
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        propsMap.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, 50000);
        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        propsMap.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, 1000000);
        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        propsMap.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 25000);
        propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        //propsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 5000);
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, group);

        return propsMap;
    }

    @Bean
    public KafkaListeners kafkaListeners() {
        return new KafkaListeners();
    }
}