package com.cpl.tsl.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消费者队列监听
 *
 * @author: lll
 * @date: 2021年04月11日 16:04:14
 */
@Component
@RabbitListener(queues = "EmployeeDirectQueue")//监听的队列名称 EmployeeDirectQueue
public class DirectReceiver {

    private static final Logger logger = LoggerFactory.getLogger(com.cpl.tsl.service.Impl.EmployeeServiceImpl.class);

    @RabbitHandler
    public void process(Map testMessage) {
        logger.info("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }

}