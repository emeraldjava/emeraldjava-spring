package ie.emeraldjava.springaop.serviceb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class ServiceBImpl implements ServiceB {

    @PostConstruct
    public void postC() {
        log.info("{}","ServiceBImpl.postConstruct");
    }


    @Override
    public boolean doesSomething() {
        log.info("{}","doesSomething");
        return false;
    }
}
