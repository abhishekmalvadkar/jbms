package com.amalvadkar.jbms.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(WelcomeController.class)
public class WelcomeControllerMvcTest {

    @Autowired
    MockMvcTester mockMvcTester;

    @Test
    void getToWebsiteReturns200WithWelcomePage() {
        mockMvcTester.perform(get("/"))
                .assertThat()
                .hasStatus2xxSuccessful()
                .hasViewName("welcome");
    }

    @Test
    void getToWebsiteReturns200WithWelcomePageAlongWithRequiredDetails() {
        mockMvcTester.perform(get("/"))
                .assertThat()
                .hasStatus2xxSuccessful()
                .hasViewName("welcome")
                .model()
                .extractingByKeys("welcomeMessage", "totalBookmarksCount", "totalTagsCount")
                .hasSameElementsAs(List.of("Welcome to JBMS", 2, 3));
    }
}
