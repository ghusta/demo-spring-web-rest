package org.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @PostConstruct
    void init() {
        log.debug("*** {} initialized ***", this.getClass().getSimpleName());
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    /**
     * Will return JSON object.
     */
    @GetMapping("/map")
    public Map<String, ?> returnMap() {
        return Map.of("Hello", "World!");
    }

}