package ie.emeraldjava.dualctxs.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@Slf4j
@Getter
@Setter
//@ComponentScan("ie.emeraldjava.dualctxs")
public class AppConfig {

    @PostConstruct
    public void postC() {
        log.info("{}","AppConfig.postConstruct");
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

}
