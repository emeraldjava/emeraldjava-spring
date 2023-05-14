package ie.emeraldjava.dualctxs.config.regionA;

import ie.emeraldjava.dualctxs.controller.RegionController;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@Slf4j
@ComponentScan("ie.emeraldjava.dualctxs.config.regionA")
@EnableAutoConfiguration
@PropertySource("classpath:regionA.properties")
@Getter
public class RegionAConfig {

    @Value( "${app.region}" )
    private String region;

    @PostConstruct
    public void postC() {
        log.info("{}:{}","RegionAConfig.postConstruct",region);
    }

    @Bean
    //@Primary
    @ConfigurationProperties(prefix = "spring.regiona")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public RegionController getRegionAController() {
        return new RegionController(getRegion());
    }
}