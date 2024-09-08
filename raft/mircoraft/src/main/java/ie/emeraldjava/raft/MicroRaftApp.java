package ie.emeraldjava.raft;

import ie.emeraldjava.raft.service.RaftService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MicroRaftApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MicroRaftApp.class, args);
    }

    @Autowired
    private RaftService raftService;

    @Override
    public void run(String... args) throws Exception {
        log.info("MicroRaftApp: {}",raftService);
    }
}
