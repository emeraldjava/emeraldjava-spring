package com.github.emeraldjava.yamlprops.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Data
public class Setup {
    private String name;
    private String tag;
}
