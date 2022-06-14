package org.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AnalyticsAspect {

    //using pointcut declarations
    @Before("org.aop.aspect.DemoAspect.daoPackageExpression()")
    public void analytics(){
        System.out.println("executing analytics");
    }

}
