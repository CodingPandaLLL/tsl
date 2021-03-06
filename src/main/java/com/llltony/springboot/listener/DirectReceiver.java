package com.llltony.springboot.listener;

import org.apache.log4j.Logger;
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

    private static final Logger logger = Logger.getLogger(com.llltony.springboot.service.Impl.EmployeeServiceImpl.class);

    @RabbitHandler
    public void process(Map testMessage) {
        logger.info("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }

}