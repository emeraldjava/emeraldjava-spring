package ie.emeraldjava.springaop.serviceb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class ServiceBImpl implements ServiceB, SubServiceB {

    @Autowired
    private SubServiceB subServiceB;

    @PostConstruct
    public void postC() {
        log.info("{}","ServiceBImpl.postConstruct");
    }


    @Override
    public boolean doesSomething(Long id) throws Exception {
        log.info("{}:{}","doesSomething",id);
        doALittleMore(id);
        if(id==-1) {
            throw new Exception("");
        }
        subServiceB.doALittleMore(id);
        return false;
    }

    @Override
    public void doALittleMore(Long id) {
        log.info("{}:{}","inner doALittleMore() which will not be aspect intercepted",id);
    }
}
