package org.aop.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("org.aop")
public class AopConfig
{

}
