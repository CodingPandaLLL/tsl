package com.cpl.tsl.demo.addField;


import com.alibaba.fastjson.JSON;
import com.cpl.tsl.listener.DataDictSerializeFilter;

import java.math.BigDecimal;

/**
 * @Date 2022/3/9 14:20
 * @Version 1.0
 */
public class Demo8 {
    public static void main(String[] args) {
        JyAfterFilter jyAfterFilter = new JyAfterFilter();
        Apple apple = new Apple(1, "lili", new BigDecimal("11"), 1, "028");
        String jsonString = JSON.toJSONString(apple, jyAfterFilter);
        System.out.println(jsonString);
    }
}

