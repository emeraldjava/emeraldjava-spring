package ie.emeraldjava.springaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Aspect
@Slf4j
public class SubServiceBLoggingAspect {

    @PostConstruct
    public void postC() {
        log.info("{}","SubServiceBLoggingAspect.postConstruct");
    }

    @Pointcut("execution(* ie.emeraldjava.springaop.serviceb.SubServiceB.doALittleMore(..))")
    public void logPointcutSubServiceB() {}

    @Before("logPointcutSubServiceB()")
    public void beforeLogPointcutServiceB(JoinPoint joinPoint) throws Throwable {
        log.info("--> In SubServiceBLoggingAspect from beforeLogPointcutServiceB");
        log.info("--> arg "+joinPoint.getArgs()[0]);
    }
}