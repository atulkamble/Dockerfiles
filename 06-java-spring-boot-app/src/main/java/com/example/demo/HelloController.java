package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    /** Root endpoint — returns a greeting string. */
    @GetMapping("/")
    public String hello() {
        return "Hello, Spring Boot on Docker!";
    }

    /** Health-check endpoint for container orchestrators. */
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "ok");
    }
}
