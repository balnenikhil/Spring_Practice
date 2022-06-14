package org.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DemoAspect {

    //pointcut expressions

    //using exact qualified class name
    //@Before("execution(public void org.aop.dao.AccountDAO.addAccount())")

    //using only mandatory ones some names are optional
    //@Before("execution(public void addAccount())")

    //using wildcard
    //@Before("execution(public void add*())")

    //using return type
    //@Before("execution(public String add*())")

    //expression for all classes in a package
    //@Before("execution(* org.aop.dao.*.*(..))")

    //pointcut declarations used for multiple methods using same expression
    @Pointcut("execution(* org.aop.dao.*.*(..))")
    public void daoPackageExpression(){}

    //second pointcut declaration
    @Pointcut("execution(public String add*())")
    private void returnTypeExpression(){}


    //using pointcut declarations
    @Before("daoPackageExpression()")
    public void beforeAddAccountAdvice(){
        System.out.println("executing addAccount");
    }


    //we can use &&, ||, ! to combine pointcut declarations
    @Pointcut("daoPackageExpression() || returnTypeExpression()")
    private void mixedPointcutExpressions(){}
}
