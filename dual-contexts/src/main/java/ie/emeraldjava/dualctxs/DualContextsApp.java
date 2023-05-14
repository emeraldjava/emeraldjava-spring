package ie.emeraldjava.dualctxs;

import ie.emeraldjava.dualctxs.config.AppConfig;
import ie.emeraldjava.dualctxs.config.regionA.RegionAConfig;
import ie.emeraldjava.dualctxs.config.regionB.RegionBConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//(exclude = HibernateJpaAutoConfiguration.class)
@Slf4j
public class DualContextsApp implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
//            .parent(DualContextsApp.class).web(WebApplicationType.SERVLET)
            .parent(AppConfig.class).web(WebApplicationType.NONE)
            .child(RegionAConfig.class).web(WebApplicationType.SERVLET)
            .sibling(RegionBConfig.class).web(WebApplicationType.SERVLET)
            .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("{}","run");
    }
}