package org.aop.aspect;

import org.aop.bean.Account;
import org.aop.demo.AopDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class DemoAspect {

    private static Logger logger = Logger.getLogger(AopDemoApp.class.getName());
    //pointcut declarations used for multiple methods using same expression
    @Pointcut("execution(* org.aop.dao.*.*(..))")
    public void daoPackageExpression(){}

    //second pointcut declaration
    @Pointcut("execution(public String add*())")
    private void returnTypeExpression(){}

    //we can use &&, ||, ! to combine pointcut declarations
    @Pointcut("daoPackageExpression() || returnTypeExpression()")
    private void mixedPointcutExpressions(){}

    //using pointcut declarations
    @Before("daoPackageExpression()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        logger.info("executing addAccount @Before");
        //signature method to display method details
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("method: "+methodSignature);


        // getting method parameters data
        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args){
            logger.info(""+tempArg);

        if(tempArg instanceof Account){
            Account account = (Account) tempArg;

            logger.info(""+account.getaId());
            logger.info(account.getName());
        }

        }

    }



    @AfterThrowing(pointcut = "org.aop.aspect.DemoAspect.daoPackageExpression()", throwing = "exception")
    public void  afterThrowingFIndAccountsAdvice(JoinPoint joinPoint, Throwable exception){
        String method = joinPoint.getSignature().toShortString();
        logger.info("executing after throwing"+method);
        logger.info("exception caught in after throwing : "+exception);
    }


}
