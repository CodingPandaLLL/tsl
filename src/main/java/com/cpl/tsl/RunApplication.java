package com.cpl.tsl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(value = "com.cpl.tsl.dao")
@ComponentScan("com.cpl.tsl")
@SpringBootApplication
@EnableTransactionManagement
public class RunApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.cpl.tsl.RunApplication.class, args);
    }
}

