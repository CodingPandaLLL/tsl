package com.cpl.tsl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.cpl.tsl.dao")
@SpringBootApplication
public class TslApplication {

    public static void main(String[] args) {
        SpringApplication.run(TslApplication.class, args);
    }


}