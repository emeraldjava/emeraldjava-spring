package ie.emeraldjava.dualctxs.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class AppConfig {

    @PostConstruct
    public void postC() {
        log.info("{}","AppConfig.postConstruct");
    }
}
