package com.cpl.tsl.demo.addField;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Date 2022/3/8 17:37
 * 自定义注解类,作用于实体类字段上
 * 在运行时生效
 */
@Target({FIELD})
@Retention(RUNTIME)
@Documented
public @interface TextDisplay {
    /**
     *  转换的provider，用于中文转换
     */
    Class<? extends ValueProvider> value();
}

