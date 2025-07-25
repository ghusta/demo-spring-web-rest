package org.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = "org.example.service")
@Import({JacksonConfig.class})
public class AppConfig {

    // DataSource, Services, etc.

    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

    @PostConstruct
    void init() {
        log.debug("*** {} initialized ***", this.getClass().getSimpleName());
    }

}