package com.cpl.tsl.listener;


import com.alibaba.fastjson.serializer.AfterFilter;
import com.cpl.tsl.annotation.DataDict;
import com.cpl.tsl.bean.SysDataDict;
import com.cpl.tsl.service.Impl.SysDataDictServiceImpl;
import com.cpl.tsl.utils.SpringUtil;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 序列化属性增强
 *
 * @author: lll
 * @date: 2022年03月20日 07:03:09
 */
public class DataDictSerializeFilter extends AfterFilter {
    /**
     * 表示这个包下面的类才有效
     */
    private static final String NEED_SCAN_PACKAGE = "com.cpl.tsl.bean";

    private static final String DISPLAY_SUFFIX = "Description";

    private SysDataDictServiceImpl sysDataDictServiceImpl = (SysDataDictServiceImpl) SpringUtil.getBean("sysDataDictServiceImpl");

    @Override
    public void writeAfter(Object object) {

        String packageName = object.getClass().getPackage().getName();//该方法是获取包名，可以利用该方法的结果来缩小范围
        if (!packageName.startsWith(NEED_SCAN_PACKAGE)) {
            return;
        }
        //获取所有的字段
        Field[] fields = object.getClass().getDeclaredFields();
        //遍历字段
        try {
            for (Field f : fields
            ) {
                //获取字段上的自定义注解
                Annotation annotation = f.getAnnotation(DataDict.class);
                if (annotation == null) {
                    continue;
                }
                //获取DataDict类型
                String type = f.getAnnotation(DataDict.class).type();
                if (StringUtils.isEmpty(type)) {
                    continue;
                }
                f.setAccessible(true);
                //获取属性值
                String o = f.get(object).toString();
                if (StringUtils.isEmpty(o)) {
                    continue;
                }

                //获取字典值
                SysDataDict sysDataDict = sysDataDictServiceImpl.getSysDataDictByCodeAndFCode(o, type);
                if (sysDataDict != null && !StringUtils.isEmpty(sysDataDict.getDesp())) {
                    //构造一个新的key value
                    super.writeKeyValue(f.getName() + DISPLAY_SUFFIX, sysDataDict.getDesp());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

