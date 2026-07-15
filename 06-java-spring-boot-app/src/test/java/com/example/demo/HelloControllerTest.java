package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit tests for {@link HelloController} using MockMvc.
 * The web layer is isolated — no embedded server is started.
 */
@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ── GET / ──────────────────────────────────────────────────────────────────

    @Test
    void rootEndpoint_returnsGreeting() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               // Expected greeting defined by HelloController#hello()
               .andExpect(content().string("Hello, Spring Boot on Docker!"));
    }

    // ── GET /health ───────────────────────────────────────────────────────────

    @Test
    void healthEndpoint_returnsOkStatus() throws Exception {
        mockMvc.perform(get("/health"))
               .andExpect(status().isOk())
               // Expected JSON field defined by HelloController#health()
               .andExpect(jsonPath("$.status").value("ok"));
    }
}
