package org.aop.aspect;

import org.aop.bean.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DemoAspect {


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
        System.out.println("executing addAccount @Before");
        //signature method to display method details
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("method: "+methodSignature);


        // getting method parameters data
        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args){
            System.out.println(tempArg);

        if(tempArg instanceof Account){
            Account account = (Account) tempArg;

            System.out.println(account.getaId());
            System.out.println(account.getName());
        }

        }

    }



    @AfterThrowing(pointcut = "org.aop.aspect.DemoAspect.daoPackageExpression()", throwing = "exception")
    public void  afterThrowingFIndAccountsAdvice(JoinPoint joinPoint, Throwable exception){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("executing after throwing"+method);
        System.out.println("exception caught in after throwing : "+exception);
    }


}
