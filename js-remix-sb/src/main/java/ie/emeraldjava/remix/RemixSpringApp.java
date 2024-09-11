package ie.emeraldjava.remix;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@Slf4j
public class RemixSpringApp implements CommandLineRunner { //}, WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(RemixSpringApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("RemixSpringApp");
    }

//    @Controller
//    public class WebController {
//
//        @GetMapping(value = "/")
//        public String index() {
//            log.info("index");
//            return "index.html";
//        }
//    }

    /**
     * https://github.com/seanpolid/spring-react-vite-template/blob/master/src/main/java/com/demo/SpringReactViteTemplateApplication.java
     * @param registry
     */
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index.html");
//    }
}
