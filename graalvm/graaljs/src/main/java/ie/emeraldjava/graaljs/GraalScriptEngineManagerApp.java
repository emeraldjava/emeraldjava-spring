package ie.emeraldjava.graaljs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@Slf4j
public class GraalScriptEngineManagerApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GraalScriptEngineManagerApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        log.info("{}",manager.toString());
        List<ScriptEngineFactory> factories = manager.getEngineFactories();
        log.info("{}",factories.size());
        for (ScriptEngineFactory factory : factories) {
            log.info("{} - {} - {}",factory.getEngineName(),
                    factory.getEngineVersion(),
                    factory.toString());
        }
    }
}