package com.github.emeraldjava.yamlprops.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Data
public class SetupChildA {
    private String childAName;
}
