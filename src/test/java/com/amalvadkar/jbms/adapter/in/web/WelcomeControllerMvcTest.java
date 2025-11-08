package com.amalvadkar.jbms.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
public class WelcomeControllerMvcTest {

    @Autowired
    MockMvcTester mockMvcTester;

    @Test
    void getToWebsiteReturns200() {
        int status = mockMvcTester.perform(get("/"))
                .getResponse()
                .getStatus();
        assertThat(status).isEqualTo(200);
    }
}
