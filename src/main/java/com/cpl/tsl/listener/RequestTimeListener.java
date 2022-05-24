package com.cpl.tsl.listener;

import com.cpl.tsl.bean.ResultMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * class description
 *
 * @author: lll
 * @date: 2022年05月24日 16:05:39
 */
@Component("requestTimeListener")
@Aspect
@EnableAsync  // 启用异步任务
public class RequestTimeListener {

    private static final Logger logger = LoggerFactory.getLogger(RequestTimeListener.class);

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    /**
     * 在请求之中拦截获取拦截
     */
    @Around("execution(* com.cpl.tsl.controller.*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        final Future<Object> future = threadPoolTaskExecutor.submit(() -> {
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throw new RuntimeException(throwable);
            }
        });
        try {
            HttpServletRequest request =
                    ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
            final String uri = request.getRequestURI();

            return ResultMap.resultSuccess(future.get(5, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            return ResultMap.resultError("400","被中断了");
        } catch (
                ExecutionException e) {
            return ResultMap.resultError("400","执行任务发生异常");
        } catch (TimeoutException e) {
            return ResultMap.resultError("400","接口响应超时");
        }

//        // result的值就是被拦截方法的返回值
//        Object result = pjp.proceed();
//        try {
//            Signature signature = pjp.getSignature();
//            MethodSignature methodSignature = (MethodSignature) signature;
//            // 被切的方法
//            Method method = methodSignature.getMethod();
//            // 返回类型
//            Class<?> methodReturnType = method.getReturnType();
//            if (!resultMapName.equals(methodReturnType.getName())) {
//                return result;
//            }
//            // 实例化
//            SwaggerResultUtil swaggerResultUtil = new SwaggerResultUtil();
//            Field[] fieldInfo = methodReturnType.getDeclaredFields();
//            for (Field field : fieldInfo) {
//                field.setAccessible(true);
//                if (msg.equals(field.getName()) && field.get(result) != null) {
//                    swaggerResultUtil.setMsg(field.get(result).toString());
//                }
//                if (code.equals(field.getName()) && field.get(result) != null) {
//                    swaggerResultUtil.setCode(Integer.valueOf(field.get(result).toString()));
//                }
//                if (bizCode.equals(field.getName()) && field.get(result) != null) {
//                    swaggerResultUtil.setBizCode(field.get(result).toString());
//                }
//                if (dataSize.equals(field.getName()) && field.get(result) != null) {
//                    swaggerResultUtil.setDataSize(Integer.valueOf(field.get(result).toString()));
//                }
//                if (data.equals(field.getName()) && field.get(result) != null) {
//                    logger.info(field.get(result).getClass().getName());
//                    DataDictSerializeFilter dataDictSerializeFilter = new DataDictSerializeFilter();
//                    // list，特殊处理一下
//                    int key = Integer.MIN_VALUE;
//                    if (field.get(result) instanceof List) {
//                        List list = (List) field.get(result);
//                        List resultList = new ArrayList();
//                        for (Object o : list) {
//                            if (matches(o.getClass().getName())) {
//                                JSONObject resultJson = writeFieldToObject(dataDictSerializeFilter, o);
//                                resultList.add(resultJson);
//                            } else {
//                                key = -1;
//                                break;
//                            }
//                        }
//                        swaggerResultUtil.setData(resultList);
//                    } else {
//                        if (matches(field.get(result).getClass().getName()) || field.get(result).getClass().getName().startsWith(NEED_SCAN_PACKAGE_PAGE)) {
//                            JSONObject resultJson = writeFieldToObject(dataDictSerializeFilter, field.get(result));
//                            swaggerResultUtil.setData(resultJson);
//                        } else {
//                            key = -1;
//                        }
//                    }
//                    if (key == -1) {
//                        swaggerResultUtil.setData(field.get(result));
//                    }
//                }
//            }
//            return swaggerResultUtil;
//        } catch (Exception exception) {
//            logger.info("字段增强异常：{} 错误信息:{}", exception.getStackTrace(),exception.getMessage());
//            return result;
//        }
    }

}
