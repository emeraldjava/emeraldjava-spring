package ie.emeraldjava.spring.rest.config;

import ie.emeraldjava.spring.rest.service.UserService;
import ie.emeraldjava.spring.rest.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pauloconnell on 18/04/17.
 */
@Configuration
public class Config {

    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }
}
