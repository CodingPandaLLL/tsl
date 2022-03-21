package com.cpl.tsl.demo.addField;

/**
 * @Date 2022/3/8 17:40
 * @Version 1.0
 */
public interface ValueProvider {
    /**
     *
     * @param val 对应的就是该字段的值
     * @return
     */
    String getDisplayText(Object val);
}


