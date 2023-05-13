package ie.emeraldjava.springaop.serviceb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class SubServiceBImpl implements SubServiceB {

    @PostConstruct
    public void postC() {
        log.info("{}","SubServiceBImpl.postConstruct");
    }

    @Override
    public void doALittleMore(Long id) {
        log.info("{} {}","doALittleMore",id);
    }
}

