package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.application.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(TagController.class)
public class TagControllerMvcTest {

    @Autowired
    MockMvcTester mockMvcTester;

    @MockitoBean
    TagService tagService;

    @Test
    void getToTagEndpointReturns200() {
        mockMvcTester.perform(get("/tags"))
                .assertThat()
                .hasStatus2xxSuccessful();
    }
}
