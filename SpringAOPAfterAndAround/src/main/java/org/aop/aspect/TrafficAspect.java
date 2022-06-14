package org.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Order(-1)
public class TrafficAspect {
    @Around("org.aop.aspect.DemoAspect.daoPackageExpression()")
    public Object aroundTraffic(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("executing around returning"+method);

        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("time for execution in ms : "+duration);
        return result;
    }
}
