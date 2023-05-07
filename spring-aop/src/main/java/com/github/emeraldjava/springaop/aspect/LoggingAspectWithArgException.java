package com.github.emeraldjava.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspectWithArgException {
    
    @Pointcut("execution(* com.github.emeraldjava.springaop.service.IBillArgsException.createBillEx(*))")
    public void logPointcutArgsException() {}

    @Before("logPointcutArgsException()")
    public void logMethodCallsWithArgsAdvice(JoinPoint joinPoint) throws Throwable {
        System.out.println("In Aspect from logPointcutArgsException "+joinPoint.getSignature().getName());
        System.out.println("arg "+joinPoint.getArgs()[0]);
        if( ((Long)(joinPoint.getArgs()[0])).equals(Long.parseLong("5"))) {
            System.out.println("here ");
            throw new Exception("LoggingAspectWithArgException");
            //throw new RuntimeException("LoggingAspectWithArgException");
        }
    }
}

