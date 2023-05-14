package ie.emeraldjava.dualctxs.config.regionA;

import ie.emeraldjava.dualctxs.controller.RegionController;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@Slf4j
@ComponentScan("ie.emeraldjava.dualctxs.config.regionA")
@EnableAutoConfiguration
@PropertySource("classpath:regionA.properties")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryRegionA",
        transactionManagerRef = "transactionManagerRegionA",
        basePackages = { "ie.emeraldjava.dualctxs.domain.repo" }
)
public class RegionAConfig {

    @Value( "${app.region}" )
    private String region;

    @PostConstruct
    public void postC() {
        log.info("{}:{}","RegionAConfig.postConstruct",region);
    }

    @Bean(name="datasourceRegionA")
    @ConfigurationProperties(prefix = "spring.regiona")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean
//    public RegionController getRegionAController() {
//        return new RegionController(getRegion());
//    }

    @Primary
    @Bean(name="entityManagerFactoryRegionA")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (EntityManagerFactoryBuilder builder,
             @Qualifier("datasourceRegionA") DataSource dataSource){
        // https://www.javadevjournal.com/spring-boot/multiple-data-sources-with-spring-boot/
        return builder
                .dataSource(dataSource)
                .packages("ie.emeraldjava.dualctxs.domain.jpa")
                .persistenceUnit("Global")
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerRegionA")
    //@ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactoryRegionA") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}