package com.github.emeraldjava.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.github.emeraldjava.springaop.service.IBillNoArgs.createBill())")
    public void logPointcutNoArgs() {}

    @Before("logPointcutNoArgs()")
    public void logMethodCallsWithArgsAdvice() {
        System.out.println("In Aspect from logPointcutNoArgs");
    }
}

