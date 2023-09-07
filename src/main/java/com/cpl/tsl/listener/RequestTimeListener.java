package com.cpl.tsl.listener;

import com.cpl.tsl.bean.base.ResultMap;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
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

    @Value(value = "${noRequestTimeOutTime:1500000}")
    private Integer outTime;

    //应用层不限制超时时间的URL集合
    @Value(value = "${noRequestTimeLimitUrl:null}")
    public String noRequestTimeLimitUrl;

    private static InheritableThreadLocal<SystemLocalContext> systemLocalContextInheritableThreadLocal = new InheritableThreadLocal<>();

    /**
     * 在请求之中拦截获取拦截
     */
    @Around("execution(* com.cpl.tsl.controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        /**
         * 方法一：需要在执行完成后才能判断，接口实际时长已经超出15s,并没有真正熔断
         */
//        try {
//            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
//            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
//            assert sra != null;
//            HttpServletRequest request = sra.getRequest();
//            final String uri = request.getRequestURI();
//            //不限制请求时长的接口不予处理
//            if (noRequestTimeLimitUrl != null && noRequestTimeLimitUrl.split(",").length > 0) {
//                String[] urls = noRequestTimeLimitUrl.split(",");
//                for (int i = 0; i < urls.length; i++) {
//                    if (uri.endsWith(urls[i])) {
//                        return joinPoint.proceed();
//                    }
//                }
//            }
//            long startTimeMillis = System.currentTimeMillis();
//            //调用 proceed() 方法才会真正的执行实际被代理的方法
//            Object result = joinPoint.proceed();
//            long execTimeMillis = System.currentTimeMillis() - startTimeMillis;
//            //判断接口超时熔断
//            if (execTimeMillis > outTime) {
//                return SwaggerResultUtil.error500("接口响应时间超过15S,请求被拒绝！");
//            } else {
//                return result;
//            }
//        } catch (Exception exception) {
//            return joinPoint.proceed();
//        }

        /**
         * 方法二
         */
        //返回类型
        String resultClassName = "";
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            // 被切的方法
            Method method = methodSignature.getMethod();
            // 返回类型
            Class<?> methodReturnType = method.getReturnType();
            resultClassName = methodReturnType.getName();
        }
        SystemLocalContext systemLocalContext = new SystemLocalContext();
        ExecutorService ex = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
        //封装systemLocalContext信息
//        systemLocalContext.setZhId(SystemContext.getZhId());
//        systemLocalContext.setZhm(SystemContext.getZhm());
//        systemLocalContext.setSfId(SystemContext.getSfId());
//        systemLocalContext.setRysfmc(SystemContext.getRysfmc());
//        systemLocalContext.setRysfdm(SystemContext.getRysfdm());
//        systemLocalContext.setBmmc(SystemContext.getBmmc());
//        systemLocalContext.setBmdm(SystemContext.getBmdm());
//        systemLocalContext.setBmId(SystemContext.getBmId());
//        systemLocalContext.setRyxm(SystemContext.getRyxm());
//        systemLocalContext.setToken(SystemContext.getToken());
//        systemLocalContext.setIsSuperAdmin(SystemContext.isSuperAdmin());
//        systemLocalContext.setJsdj(SystemContext.getJsdj());
//        systemLocalContext.setJsId(SystemContext.getJsId());
//        systemLocalContext.setIp(SystemContext.getIp());
//        systemLocalContext.setSsoUser(SystemContext.getSystemSsoUser());
        systemLocalContextInheritableThreadLocal.set(systemLocalContext);
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        RequestContextHolder.setRequestAttributes(requestAttributes, true);
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        assert sra != null;
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        final Future<Object> future = ex.submit(() -> {
            try {
                //子线程赋值现场上下文
                //封装systemLocalContext信息
//                SystemContext.setZhId(systemLocalContextInheritableThreadLocal.get().getZhId());
//                SystemContext.setZhm(systemLocalContextInheritableThreadLocal.get().getZhm());
//                SystemContext.setSfId(systemLocalContextInheritableThreadLocal.get().getSfId());
//                SystemContext.setRysfmc(systemLocalContextInheritableThreadLocal.get().getRysfmc());
//                SystemContext.setRysfdm(systemLocalContextInheritableThreadLocal.get().getRysfdm());
//                SystemContext.setBmmc(systemLocalContextInheritableThreadLocal.get().getBmmc());
//                SystemContext.setBmdm(systemLocalContextInheritableThreadLocal.get().getBmdm());
//                SystemContext.setBmId(systemLocalContextInheritableThreadLocal.get().getBmId());
//                SystemContext.setRyxm(systemLocalContextInheritableThreadLocal.get().getRyxm());
//                SystemContext.setToken(systemLocalContextInheritableThreadLocal.get().getToken());
//                SystemContext.setIsSuperAdmin(systemLocalContextInheritableThreadLocal.get().getIsSuperAdmin());
//                SystemContext.setJsdj(systemLocalContextInheritableThreadLocal.get().getJsdj());
//                SystemContext.setJsId(systemLocalContextInheritableThreadLocal.get().getJsId());
//                SystemContext.setIp(systemLocalContextInheritableThreadLocal.get().getIp());
//                SystemContext.setSystemSsoUser(systemLocalContextInheritableThreadLocal.get().getSsoUser());
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throw new RuntimeException(throwable);
            }
        });
        try {
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
            //遗留问题：非SwaggerResultUtil接口无法监控到时长
            if (resultClassName.equals(resultMapName)) {
                return ResultMap.resultError("500","接口响应时间超过" + outTime + "S,请求被拒绝！");
            } else {
                throw new TimeoutException("接口响应时间超过" + outTime + "S,请求被拒绝！");
//                return joinPoint.proceed();
            }
        }
    }
}

/**
 * 内部类：传递现场上下文
 *
 * @author: lll
 * @date: 2023年05月05日 10:05:58
 */
@Data
class SystemLocalContext {

//    private SystemSsoUser ssoUser;
    /**
     * 账户ID
     */
    private String zhId;
    /**
     * 账户名
     */
    private String zhm;
    /**
     * 身份ID
     */
    private String sfId;
    /**
     * 身份名称
     */
    private String rysfmc;
    /**
     * 身份代码
     */
    private String rysfdm;
    /**
     * 部门名称
     */
    private String bmmc;
    /**
     * 部门代码
     */
    private String bmdm;
    /**
     * 人员姓名
     */
    private String ryxm;
    /**
     * 部门id
     */
    private String bmId;
    /**
     * token
     */
    private String token;
    /**
     * 是否超级管理员
     */
    private Boolean isSuperAdmin;
    /**
     * 角色等级
     */
    private String jsdj;
    /**
     * 角色id
     *
     * @return
     */
    private String jsId;
    /**
     * IP
     */
    private String ip;

}

