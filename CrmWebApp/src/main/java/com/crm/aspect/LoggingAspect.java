package com.crm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
     // logger
     private static Logger logger = Logger.getLogger(LoggingAspect.class.getName());

     // pointcut declarations
    @Pointcut("execution(* com.crm.controller.*.*(..))")
    private void ControllerPackage(){}

    @Pointcut("execution(* com.crm.dao.*.*(..))")
    private void DaoPackage(){}

    @Pointcut("execution(* com.crm.service.*.*(..))")
    private void ServicePackage(){}

    //combining declarations
    @Pointcut("ControllerPackage() || DaoPackage() || ServicePackage()")
    private void Packages(){}

    // adding advices to log data
    @Before("Packages()")
    public void before(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toShortString();
        logger.info(" @Before : "+method);

        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args){
            logger.info("@arguments : "+tempArg);
        }
    }

    @Around("Packages()")
    public Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        String duration = String.valueOf(end - begin);

        logger.info(duration);

        return result;
    }
}
