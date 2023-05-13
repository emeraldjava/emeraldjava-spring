package ie.emeraldjava.springaop.aspect;

import lombok.extern.slf4j.Slf4j;
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

    @Pointcut("execution(* ie.emeraldjava.springaop.serviceb.ServiceB.doesSomething())")
    public void logPointcutServiceB() {}

    @Before("logPointcutServiceB()")
    public void beforeLogPointcutServiceB() {
        log.info("In ServiceBLoggingAspect from beforeLogPointcutServiceB");
    }
}