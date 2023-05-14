package ie.emeraldjava.dualctxs.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
@Getter
@Setter
//exclude = {
//        DataSourceAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class}
//@ComponentScan("ie.emeraldjava.dualctxs")
public class AppConfig {

    @PostConstruct
    public void postC() {
        log.info("{}","AppConfig.postConstruct");
    }

}
