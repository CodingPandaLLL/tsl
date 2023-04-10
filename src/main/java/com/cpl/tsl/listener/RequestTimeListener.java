package com.cpl.tsl.listener;

import com.cpl.tsl.bean.base.ResultMap;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.*;

/**
 * 监听接口时长进行超时拦截
 *
 * @author: lll
 * @date: 2022年05月24日 16:05:39
 */
@Aspect
@Component
@Slf4j
public class RequestTimeListener {

    //拦截解析结果类
    private final String resultMapName = "com.cpl.tsl.bean.base.ResultMap";

    //超时时间15秒
    private final Integer outTime = 15;

    //应用层不限制超时时间的URL集合
    @Value(value = "${noRequestTimeLimitUrl:null}")
    public String noRequestTimeLimitUrl;

    /**
     * 在请求之中拦截获取拦截
     */
    @Around("execution(* com.cpl.tsl.controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ExecutorService ex = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
        final Future<Object> future = ex.submit(() -> {
            //设置在子线程中传递上下文
            RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
            RequestContextHolder.setRequestAttributes(requestAttributes, true);
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throw new RuntimeException(throwable);
            }
        });
        try {
            RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            assert sra != null;
            HttpServletRequest request = sra.getRequest();
            final String uri = request.getRequestURI();
            //不限制请求时长的接口不予处理
            if (noRequestTimeLimitUrl != null && noRequestTimeLimitUrl.split(",").length > 0) {
                String[] urls = noRequestTimeLimitUrl.split(",");
                for (int i = 0; i < urls.length; i++) {
                    if (uri.endsWith(urls[i])) {
                        return joinPoint.proceed();
                    }
                }
            }
            return future.get(outTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return joinPoint.proceed();
        } catch (ExecutionException e) {
            return joinPoint.proceed();
        } catch (TimeoutException e) {
            //常规返回结果
            if (joinPoint.proceed().getClass().getName().equals(resultMapName)) {
                return ResultMap.resultError("500", "接口响应时间超过" + outTime + "S,请求被拒绝！");
            } else {
                return joinPoint.proceed();
            }
        }
    }

}

