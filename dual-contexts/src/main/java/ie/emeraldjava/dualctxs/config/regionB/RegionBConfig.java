package ie.emeraldjava.dualctxs.config.regionB;

import ie.emeraldjava.dualctxs.controller.RegionController;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@Slf4j
@Getter
@ComponentScan("ie.emeraldjava.dualctxs.config.regionB")
@EnableAutoConfiguration
@PropertySource("classpath:regionB.properties")
public class RegionBConfig {

    @Value( "${app.region}" )
    private String region;
    @PostConstruct
    public void postC() {
        log.info("{}:{}","RegionBConfig.postConstruct",region);
    }

    @Bean
    //@Primary
    @ConfigurationProperties(prefix = "spring.regionb")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public RegionController getRegionBController() {
        return new RegionController(getRegion());
    }
}
