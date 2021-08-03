package com.example.customannotation.aspect;

import com.example.customannotation.annotation.SysLog;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 利用aop实现注解功能
 * @author qzz
 */
@Aspect
@Component
public class SysLogAspect {

    @Pointcut("@annotation(com.example.customannotation.annotation.SysLog)")
    public void logPointCut(){

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //方法返回结果
        Object result = joinPoint.proceed();
        //执行时长
        long time = System.currentTimeMillis() - beginTime;

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //获取自定义注解上的值
        SysLog sysLog = method.getAnnotation(SysLog.class);
        String sysLogValue  = sysLog.value();
        String sysLogDesc  = sysLog.desc();

        //获取调用的类名、方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();

        //方法入参
        Object[] args = joinPoint.getArgs();
        System.out.println("注解上的值："+ (StringUtils.isBlank(sysLogValue)?sysLogDesc:sysLogValue));
        System.out.println("执行时间："+time);
        System.out.println("执行的类和方法："+className+"."+methodName+"()");
        System.out.println("执行结果："+result);
        return result;
    }
}
