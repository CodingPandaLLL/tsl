package com.cpl.tsl.utils;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DirectRabbitConfig
 *
 * @author: lll
 * @date: 2021年04月11日 15:04:38
 */
@Configuration
public class DirectRabbitConfig {



    //队列 起名：EmployeeDirectQueue
    @Bean
    public Queue EmployeeDirectQueue() {
        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        //   return new Queue("EmployeeDirectQueue",true,true,false);

        //一般设置一下队列的持久化就好,其余两个就是默认false
        return new Queue("EmployeeDirectQueue",true);
    }

    //Direct交换机 起名：EmployeeDirectExchange
    @Bean
    DirectExchange EmployeeDirectExchange() {
        //  return new DirectExchange("EmployeeDirectExchange",true,true);
        return new DirectExchange("EmployeeDirectExchange",true,false);
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：EmployeeDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(EmployeeDirectQueue()).to(EmployeeDirectExchange()).with("EmployeeDirectRouting");
    }



    @Bean
    DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange");
    }



}
