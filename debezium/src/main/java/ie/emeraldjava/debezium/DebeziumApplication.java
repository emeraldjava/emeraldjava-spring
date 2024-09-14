package ie.emeraldjava.debezium;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@Slf4j
public class DebeziumApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DebeziumApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("run",args);
    }
}
