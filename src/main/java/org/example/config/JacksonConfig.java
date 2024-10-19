package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
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
        ObjectMapper objectMapper = JsonMapper.builder()
                .build();
        // Customize objectMapper as needed
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }
}
