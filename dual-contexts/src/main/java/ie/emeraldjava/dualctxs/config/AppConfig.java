package ie.emeraldjava.dualctxs.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@Slf4j
//@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef = "transactionManager",
    basePackages = { "ie.emeraldjava.dualctxs.domain.repo" })
public class AppConfig {

    @PostConstruct
    public void postC() {
        log.info("{}","AppConfig.postConstruct");
    }

    @Primary
    @Bean(name="datasource")
    //@ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Primary
//    @Bean(name="dsProps")
//    @ConfigurationProperties("spring.datasource")
//    public DataSourceProperties dataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Primary
//    @Bean(name="datasource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource datasource(@Qualifier("dsProps") DataSourceProperties properties){
//        log.info("{}",properties.toString());
//        return properties.initializeDataSourceBuilder().build();
//    }

    @Primary
    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (EntityManagerFactoryBuilder entityManagerFactoryBuilder,
             @Qualifier("datasource") DataSource dataSource){
        // https://www.javadevjournal.com/spring-boot/multiple-data-sources-with-spring-boot/
        // https://stackoverflow.com/a/59461049/55794
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("ie.emeraldjava.dualctxs.domain.jpa")
                .persistenceUnit("Global")
                .build();
    }

    @Primary
    @Bean(name = "transactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    /**
     *
     * https://stackoverflow.com/questions/67966956/required-a-bean-of-type-org-springframework-boot-orm-jpa-entitymanagerfactorybu
     * @return
     */
    @Bean
    @Primary
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(
                new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }

}
