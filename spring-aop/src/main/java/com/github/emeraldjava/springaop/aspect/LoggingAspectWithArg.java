package com.github.emeraldjava.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspectWithArg {
    
    @Pointcut("execution(* com.github.emeraldjava.springaop.service.IBillArgs.createBill(*))")
    public void logPointcutArgs() {}

    /**
     *
     * https://reflectoring.io/aop-spring/
     * @param joinPoint
     */
    @Before("logPointcutArgs()")
    public void logMethodCallsWithArgsAdvice(JoinPoint joinPoint) {
        System.out.println("In Aspect from logPointcutArgs "+joinPoint.getSignature().getName());
        System.out.println("arg "+joinPoint.getArgs()[0]);
    }
}

