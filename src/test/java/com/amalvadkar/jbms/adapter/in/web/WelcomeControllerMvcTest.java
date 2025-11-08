package com.amalvadkar.jbms.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(WelcomeController.class)
public class WelcomeControllerMvcTest {

    @Autowired
    MockMvcTester mockMvcTester;

    @Test
    void getToWebsiteReturns200WithWelcomePage() {
        MvcResult mvcResult = mockMvcTester.perform(get("/"))
                .getMvcResult();

        int status = mvcResult.getResponse().getStatus();
        assertThat(status).isEqualTo(200);

        ModelAndView modelAndView = mvcResult.getModelAndView();
        String viewName = Objects.requireNonNull(modelAndView).getViewName();
        assertThat(viewName).isEqualTo("welcome");
    }

    @Test
    void getToWebsiteReturns200WithWelcomePageAlongWithRequiredDetails() {
        ModelAndView modelAndView = mockMvcTester.perform(get("/"))
                .getMvcResult().getModelAndView();

        Map<String, Object> model = Objects.requireNonNull(modelAndView).getModel();
        assertThat(model.get("welcomeMessage")).isEqualTo("Welcome to JBMS");
        assertThat(model.get("totalBookmarksCount")).isEqualTo(2);
        assertThat(model.get("totalTagsCount")).isEqualTo(3);

        assertThat(modelAndView.getViewName()).isEqualTo("welcome");
    }
}
