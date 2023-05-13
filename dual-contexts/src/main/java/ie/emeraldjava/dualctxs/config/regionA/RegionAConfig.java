package ie.emeraldjava.dualctxs.config.regionA;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
@ComponentScan("ie.emeraldjava.dualctxs.config.regionA")
@EnableAutoConfiguration
@PropertySource("classpath:regionA.properties")
public class RegionAConfig {
    @PostConstruct
    public void postC() {
        log.info("{}","RegionAConfig.postConstruct");
    }
}