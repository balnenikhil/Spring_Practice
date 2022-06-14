package org.aop.aspect;

import org.aop.bean.Account;
import org.aop.demo.AopDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(3)
public class AnalyticsAspect {
    private static Logger logger = Logger.getLogger(AopDemoApp.class.getName());
    //using pointcut declarations
    @After("org.aop.aspect.DemoAspect.daoPackageExpression()")
    public void analytics(){
        logger.info("executing analytics @After");
    }

    @AfterReturning(pointcut = "org.aop.aspect.DemoAspect.daoPackageExpression()", returning = "accounts")
    public void afterReturnFindAccounts(JoinPoint joinPoint, List<Account> accounts){
        String method = joinPoint.getSignature().toShortString();
        logger.info("executing after returning"+method);
        logger.info("accounts are :"+accounts);

        //processing or changing the data before it is going to calling method
        changingResultToUpperCase(accounts);
    }

    private void changingResultToUpperCase(List<Account> accounts) {
        for(Account tempAccount : accounts)
            tempAccount.setName(tempAccount.getName().toUpperCase());
    }

}
