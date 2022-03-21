package com.cpl.tsl.demo.addField;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.serializer.AfterFilter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @Date 2022/3/8 17:20
 * BeforeFilter 序列化时在最前添加内容
 * AfterFilter 序列化时在最后添加内容
 */
public class JyAfterFilter extends AfterFilter{
    /**
     * 表示这个包下面的类才有效
     */
    private static final String NEED_SCAN_PACKAGE = "com.cpl.tsl.demo.addField";

    private static final String DISPLAY_SUFFIX = "Text";

    @Override
    public void writeAfter(Object object) {
        /**
         * BeforeFilter和AfterFilter的用法类似，这里就不单独举例了
         * 该用例中，我们主要处理的是在实际开发中常遇到的将枚举值转换为中文返回前端
         * 当然这里不是直接转换，而是增加一个返回字段专门存放中文字段值
         */
        String packageName = object.getClass().getPackage().getName();//该方法是获取包名，可以利用该方法的结果来缩小范围
        if (!packageName.startsWith(NEED_SCAN_PACKAGE)) {
            return;
        }
        //获取所有的字段
        Field[] fields = object.getClass().getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        //遍历字段
        try {
            for (Field f : fields
            ) {
                //获取字段上的自定义注解
                Annotation annotation = f.getAnnotation(TextDisplay.class);
                if (annotation == null) {
                    continue;
                }
                //如果不为空，则说明该字段上添加了TextDisplay注解，说明需要进行转换
                Class<? extends ValueProvider> providerClass = ((TextDisplay) annotation).value();
                //获取转换对象
                //这里因为是个人demo所以就试用的是反射机制创建的对象，在接入spring环境后最好使用spring相应的功能获取对象比如，
                // 实现接口ApplicationContextAware 注入ApplicationContext,利用getBean方法获取对象
                //1是因为反射浪费性能2是因为反射破坏了对象的单例模式
                ValueProvider valueProvider = providerClass.newInstance();
                System.out.println(valueProvider);
                f.setAccessible(true);
                String o = (String) f.get(object);
                String displayText = valueProvider.getDisplayText(o);
                if (!StringUtils.isEmpty(displayText)) {
                    //构造一个新的key value
                    super.writeKeyValue(f.getName() + DISPLAY_SUFFIX, displayText);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}


