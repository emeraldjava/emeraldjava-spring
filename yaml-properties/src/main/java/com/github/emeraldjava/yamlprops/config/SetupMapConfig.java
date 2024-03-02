package com.github.emeraldjava.yamlprops.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 *
 * See
 * https://www.baeldung.com/spring-boot-yaml-list
 * https://copyprogramming.com/howto/spring-boot-yaml-nested-property-map-to-configuration-class-hashmap
 */
@Configuration
@ConfigurationProperties(prefix="app-map-setup") // note 'setup-list' is not needed here!.
@Data
public class SetupMapConfig {

    private Map<String,Setup> map;
}
