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
public class ServiceBLoggingAspect {

    @PostConstruct
    public void postC() {
        log.info("{}","ServiceBLoggingAspect.postConstruct");
    }

    @Pointcut("execution(* ie.emeraldjava.springaop.serviceb.ServiceB.doesSomething(..))")
    public void logPointcutServiceB() {}

    @Before("logPointcutServiceB()")
    public void beforeLogPointcutServiceB(JoinPoint joinPoint) throws Throwable {
        log.info("In ServiceBLoggingAspect from beforeLogPointcutServiceB");
        log.info("arg "+joinPoint.getArgs()[0]);
        if( ((Long)(joinPoint.getArgs()[0])).equals(Long.parseLong("2"))) {
            log.info("beforeLogPointcutServiceB.exception");
            throw new Exception("LoggingAspectWithArgException");
        }
    }
}