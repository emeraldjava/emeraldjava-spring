package ie.emeraldjava.dualctxs.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * See https://zetcode.com/springboot/datasourcebuilder/
 */
@Component
@Slf4j
public class RegionReader implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {

        var sql = "SELECT * FROM region";
//        var cars = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Car.class));
//        for (Car car: cars) {
//            log.info(car);
//        }
    }
}
