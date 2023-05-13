package ie.emeraldjava.dualctxs.config.regionB;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class RegionBConfig {

    @PostConstruct
    public void postC() {
        log.info("{}","RegionBConfig.postConstruct");
    }
}
