package org.example.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

@Order(Ordered.LOWEST_PRECEDENCE)
public class PropertySourcesLoggerInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Logger log = LoggerFactory.getLogger(PropertySourcesLoggerInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();

        log.debug("Listing the ConfigurableEnvironment's propertySources (@PropertySources not displayed here as they are processed later)");
        propertySources.forEach(propertySource ->
                log.debug("* {} ({})", propertySource.getName(), propertySource.getClass()));
    }

}
