package com.cpl.tsl.demo.addField;


/**
 * @Date 2022/3/8 17:46
 * @Version 1.0
 */
public class AreaValueProvider  implements ValueProvider{
    @Override
    public String getDisplayText(Object val) {
        /**
         * 根据值返回枚举类中的中文名称
         */
        return Area.getNameByCode((String)val);
    }
}


