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
import java.util.ArrayList;
import java.util.List;

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

    //表示这个包下面的类才有效
    private static final String NEED_SCAN_PACKAGE = "com.cpl.tsl.bean";

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
                // list，特殊处理一下
                if (field.get(result) instanceof List) {
                    List list = (List) field.get(result);
                    List resultList = new ArrayList();
                    for (Object o : list) {
                        JSONObject resultJson = writeFieldToObject(dataDictSerializeFilter, o);
                        resultList.add(resultJson);
                    }
                    resultMap.setData(resultList);
                } else {
                    JSONObject resultJson = writeFieldToObject(dataDictSerializeFilter, field.get(result));
                    resultMap.setData(resultJson);
                }
            }
        }
        return resultMap;
    }

    private JSONObject writeFieldToObject(DataDictSerializeFilter dataDictSerializeFilter, Object result) throws IllegalAccessException {
        String dataString = JSON.toJSONString(result, dataDictSerializeFilter);
        JSONObject resultJson = JSONObject.parseObject(dataString);

        Field[] fields = result.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            //field Name
            String fieldName = fields[i].getName();
            String packageName = fields[i].getClass().getPackage().getName();
            //include other bean
            if (packageName.startsWith(NEED_SCAN_PACKAGE)) {
                String sonJsonString = JSON.toJSONString(fields[i].get(result), dataDictSerializeFilter);
                JSONObject sonResultJson = JSONObject.parseObject(sonJsonString);
                resultJson.put(fieldName, sonResultJson);
            }
            //include list
            fields[i].setAccessible(true);
            if (fields[i].get(result) instanceof List) {
                List list = (List) fields[i].get(result);
                List resultList = new ArrayList();
                for (Object o : list) {
                    String sonListJsonString = JSON.toJSONString(o, dataDictSerializeFilter);
                    JSONObject sonListResultJson = JSONObject.parseObject(sonListJsonString);
                    resultList.add(sonListResultJson);
                }
                resultJson.put(fieldName, resultList);
            }
        }

        return resultJson;
    }

}
