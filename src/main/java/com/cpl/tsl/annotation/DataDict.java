package com.cpl.tsl.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 *
 * @author: lll
 * @date: 2022年03月21日 17:03:08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Documented
public @interface DataDict {
    /**
     * 分类
     *
     * @return 分类
     */
    String type();
}