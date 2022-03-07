package com.cpl.tsl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * tsl启动程序
 *
 * @author: lll
 * @date: 2022年03月07日 11:03:48
 */
@MapperScan(value = "com.cpl.tsl.dao")
@ComponentScan("com.cpl.tsl")
@SpringBootApplication
@EnableTransactionManagement
public class TslApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.cpl.tsl.TslApplication.class, args);
    }
}

