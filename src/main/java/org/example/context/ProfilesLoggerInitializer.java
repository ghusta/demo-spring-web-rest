package org.example.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

@Order(Ordered.HIGHEST_PRECEDENCE + 100)
public class ProfilesLoggerInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Logger log = LoggerFactory.getLogger(ProfilesLoggerInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();
        String[] defaultProfiles = environment.getDefaultProfiles();

        if (activeProfiles.length > 0) {
            if (log.isDebugEnabled()) {
                log.debug("Spring active profiles: {}", String.join(", ", activeProfiles));
            }
        } else {
            if (log.isDebugEnabled()) {
                log.debug("Spring default profiles: {}", String.join(", ", defaultProfiles));
            }
        }
    }

}
