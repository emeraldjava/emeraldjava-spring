package com.github.emeraldjava.yamlprops;

import com.github.emeraldjava.yamlprops.config.SetupListConfig;
import com.github.emeraldjava.yamlprops.config.SetupMapConfig;
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
public class YamlPropsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(YamlPropsApplication.class, args);
    }

    @Autowired
    private SetupListConfig listConfig;

    @Autowired
    private SetupMapConfig mapConfig;

    @Override
    public void run(String... args) throws Exception {
        // print the content of the list/map from application.yml

        log.info("listConfig:{}/{}",listConfig.getList().size(),listConfig.getList());
        // listConfig:2/[Setup(name=a, tag=a-list-value), Setup(name=b, tag=b-list-value)]
        // listConfig:2/[Setup(name=a, tag=a-list-value, childA=SetupChildA(childAName=listChildA), childB=null), Setup(name=b, tag=b-list-value, childA=null, childB=SetupChildB(childBName=listChildB))]

        log.info("mapConfig:{}/{}",mapConfig.getMap().size(),mapConfig.getMap());
        // mapConfig:2/{aValue=Setup(name=a, tag=a-map-value), bValue=Setup(name=b, tag=b-map-value)}
        // mapConfig:2/{aValue=Setup(name=a, tag=a-map-value, childA=SetupChildA(childAName=mapChildA), childB=SetupChildB(childBName=mapChildB)), bValue=Setup(name=b, tag=b-map-value, childA=null, childB=null)}
    }
}