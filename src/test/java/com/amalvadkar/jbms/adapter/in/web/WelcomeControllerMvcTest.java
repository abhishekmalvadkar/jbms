package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.application.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(WelcomeController.class)
public class WelcomeControllerMvcTest {

    @Autowired
    MockMvcTester mockMvcTester;

    @MockitoBean
    WelcomeService welcomeService;

    @Test
    void getToWebsiteReturns200() {
        mockMvcTester.perform(get("/"))
                .assertThat()
                .hasStatus2xxSuccessful();
    }

}
