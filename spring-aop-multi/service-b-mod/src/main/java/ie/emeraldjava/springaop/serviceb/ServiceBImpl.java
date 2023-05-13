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
    public boolean doesSomething(Long id) throws Exception {
        log.info("{}:{}","doesSomething",id);
        if(id==-1)
            throw new Exception("");
        return false;
    }
}
