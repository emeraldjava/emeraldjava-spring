package ie.emeraldjava.raft.config;

import ie.emeraldjava.raft.interceptor.RaftHeaderInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * https://www.baeldung.com/spring-extract-custom-header-request
 */
@Configuration
public class HeaderInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(operatorInterceptor());
    }

    @Bean
    public RaftHeaderInterceptor operatorInterceptor() {
        return new RaftHeaderInterceptor();
    }
}
