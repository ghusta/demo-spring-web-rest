package org.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;

@Configuration(proxyBeanMethods = false)
@EnableWebMvc
@ComponentScan(basePackages = "org.example.controller")
public class WebMvcConfig {

    private static final Logger log = LoggerFactory.getLogger(WebMvcConfig.class);

    // Add additional configuration if needed, like ViewResolvers or message converters

    @PostConstruct
    void init() {
        log.debug("*** {} initialized ***", this.getClass().getSimpleName());
    }

}
