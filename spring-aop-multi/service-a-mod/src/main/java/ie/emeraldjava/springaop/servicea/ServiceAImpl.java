package ie.emeraldjava.springaop.servicea;

import ie.emeraldjava.springaop.serviceb.ServiceB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class ServiceAImpl implements ServiceA {

    @Autowired
    private ServiceB serviceB;

    @PostConstruct
    public void postC() {
        log.info("{}","ServiceAImpl.postConstruct");
    }

    @Override
    public boolean doesStuff() {
        log.info("{}","doesStuff");
        serviceB.doesSomething();
        return false;
    }
}
