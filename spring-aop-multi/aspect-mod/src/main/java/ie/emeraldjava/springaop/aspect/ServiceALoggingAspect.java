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
public class ServiceALoggingAspect {

    @PostConstruct
    public void postC() {
        log.info("{}","ServiceALoggingAspect.postConstruct");
    }

    @Pointcut("execution(* ie.emeraldjava.springaop.servicea.ServiceA.doesStuff())")
    public void logPointcutServiceA() {}

    @Before("logPointcutServiceA()")
    public void logMethodCallsWithArgsAdvice() {
        log.info("--> In ServiceALoggingAspect from logPointcutServiceA");
    }

}