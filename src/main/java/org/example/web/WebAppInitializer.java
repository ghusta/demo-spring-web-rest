package org.example.web;

import org.example.config.AppConfig;
import org.example.config.WebMvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context
        // See: https://docs.spring.io/spring-framework/reference/core/beans/java/instantiating-container.html#beans-java-instantiating-container-web
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        // ⚠️ Manage the lifecycle of the root application context
        // If exceptions, prevent application to be deployed in container
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // ℹ️ Optional: Create context for Spring MVC, and pass it to DispatcherServlet (see javadoc for WebApplicationInitializer)
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebMvcConfig.class); // MVC-specific beans

        // Create DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}