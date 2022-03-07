package com.cpl.tsl.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * RedisKey键监听以及业务逻辑处理
 *
 * @author: lll
 * @date: 2022年03月07日 14:03:49
 */
@Component
public class RedisTaskListener extends KeyExpirationEventMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(RedisTaskListener.class);

    @Value("${applicationName:tsl}")
    private String applicationName;

    /**
     * @param listenerContainer 监听器
     */
    public RedisTaskListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expiredKey = message.toString();
        // 将拿到的过期键使用之前拼接时的特殊符号分割成字符数组
        String[] expiredKeyArr = expiredKey.split("\\|");
        String businessSign = expiredKeyArr[0].toString();
        String expiredTimeSign = expiredKeyArr[1].toString();

        logger.info(businessSign +":"+ expiredTimeSign);
        Date date = new Date();
        // 只有本业务才执行以下操作
        if (businessSign.equals(applicationName + ":ORDERINFO")) {
            logger.info("订单超时，已取消");
        } else {
            logger.error("非订单业务不做处理");
        }
    }
}