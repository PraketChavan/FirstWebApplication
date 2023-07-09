package com.example.firstwebapplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = GreetingController.class)
class FirstWebApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void homePage() throws Exception {
        mockMvc.perform(get("/index.html")).andExpect(
                content().string(containsString("Get your greeting")));
    }

    @Test
    public void greetingPage() throws Exception {
        mockMvc.perform(get("/greeting")).andExpect(
                content().string(containsString("Hello, World")));
    }

    @Test
    public void greetingPersonal() throws Exception {
        mockMvc.perform(get("/greeting").param("name", "Praket")).andExpect(
                content().string(containsString("Hello, Praket")));
    }

}
