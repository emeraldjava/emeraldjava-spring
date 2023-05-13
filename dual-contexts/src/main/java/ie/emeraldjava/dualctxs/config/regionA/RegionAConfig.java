package ie.emeraldjava.dualctxs.config.regionA;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class RegionAConfig {
    @PostConstruct
    public void postC() {
        log.info("{}","RegionAConfig.postConstruct");
    }
}