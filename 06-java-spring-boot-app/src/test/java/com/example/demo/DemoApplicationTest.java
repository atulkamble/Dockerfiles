package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Smoke test: verifies the Spring application context loads without errors.
 * Tests main() indirectly by confirming all beans wire correctly.
 */
@SpringBootTest
class DemoApplicationTest {

    @Test
    void contextLoads() {
        // If the application context fails to start, this test fails.
        // No assertions needed — the @SpringBootTest annotation is the assertion.
    }
}
