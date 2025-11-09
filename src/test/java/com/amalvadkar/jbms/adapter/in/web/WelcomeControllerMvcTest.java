package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.adapter.in.web.common.AbstractMT;
import com.amalvadkar.jbms.application.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(WelcomeController.class)
public class WelcomeControllerMvcTest extends AbstractMT {

    @MockitoBean
    WelcomeService welcomeService;

    @Test
    void getToWebsiteReturns200() {
        mockMvcTester.perform(get("/"))
                .assertThat()
                .hasStatus2xxSuccessful();
    }

}
