package com.cpl.tsl.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cpl.tsl.bean.ResultMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 属性增强拦截器
 *
 * @author: lll
 * @date: 2022年03月20日 07:03:34
 */
@Component("dataDictionary")
@Aspect
public class DataDictionaryListener {

    private static final Logger logger = LoggerFactory.getLogger(DataDictionaryListener.class);

    //返回对象属性值名称
    private String MESSAGE = "message";
    private String STATUS = "status";
    private String DATA = "data";

    //拦截解析结果类
    private String resultMapName = "com.cpl.tsl.bean.ResultMap";

    /**
     * 在请求之中拦截获取拦截
     */
    @Around("execution(* com.cpl.tsl.controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        // 被切的方法
        Method method = methodSignature.getMethod();
        // 返回类型
        Class<?> methodReturnType = method.getReturnType();
        if (!resultMapName.equals(methodReturnType.getName())) {
            return result;
        }
        // 实例化
        ResultMap resultMap = new ResultMap();
        Field[] fieldInfo = methodReturnType.getDeclaredFields();
        for (Field field : fieldInfo) {
            field.setAccessible(true);
            if (MESSAGE.equals(field.getName()) && field.get(result) != null) {
                resultMap.setMessage(field.get(result).toString());
            }
            if (STATUS.equals(field.getName()) && field.get(result) != null) {
                resultMap.setStatus(field.get(result).toString());
            }
            if (DATA.equals(field.getName()) && field.get(result) != null) {
                logger.info(field.get(result).getClass().getName());
                DataDictSerializeFilter dataDictSerializeFilter = new DataDictSerializeFilter();
                String jsonString = JSON.toJSONString(field.get(result), dataDictSerializeFilter);
                JSONObject resultJson = JSONObject.parseObject(jsonString);
                resultMap.setData(resultJson);
            }
        }
        return resultMap;
    }

}
