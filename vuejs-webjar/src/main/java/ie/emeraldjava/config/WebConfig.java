package ie.emeraldjava.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * https://www.baeldung.com/maven-webjars
 */
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /**
     * https://spring.io/blog/2014/01/03/utilizing-webjars-in-spring-boot
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");
    }
}
