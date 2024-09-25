package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.annotation.PostConstruct;

@Configuration(proxyBeanMethods = false)
public class JacksonConfig {

    private static final Logger log = LoggerFactory.getLogger(JacksonConfig.class);

    @PostConstruct
    void init() {
        log.debug("*** {} initialized ***", this.getClass().getSimpleName());
    }

    @Bean
    public MappingJackson2HttpMessageConverter jsonConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        // Customize objectMapper as needed
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }
}
