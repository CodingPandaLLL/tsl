package com.llltony.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(value = "com.llltony.springboot.dao")
@ComponentScan("com.llltony.springboot")
@SpringBootApplication
@EnableTransactionManagement
public class RunApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.llltony.springboot.RunApplication.class, args);
    }
}

