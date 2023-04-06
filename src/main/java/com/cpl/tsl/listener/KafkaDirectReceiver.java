package com.cpl.tsl.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 消费者队列监听
 *
 * @author: lll
 * @date: 2022年06月30日 14:06:06
 */
@Component
public class KafkaDirectReceiver {

    private static final Logger logger = LoggerFactory.getLogger(com.cpl.tsl.service.Impl.EmployeeServiceImpl.class);

    @Value("${kafkaStartOrNot:0}")
    private String kafkaStartOrNot;

    private final String kafkaStart = "1";

    @KafkaListener(topics = {"database-log"})
    public void consumer(ConsumerRecord<?, ?> consumerRecord) {
        if (kafkaStartOrNot.equals(kafkaStart)) {
            //判断是否为null
            Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
            logger.info(">>>>>>>>>> record =" + kafkaMessage);
            if (kafkaMessage.isPresent()) {
                //得到Optional实例中的值
                Object message = kafkaMessage.get();
                System.err.println("kafka接口到消息:" + message);
            }
        }

    }

}

