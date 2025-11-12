package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.adapter.in.web.common.AbstractMT;
import com.amalvadkar.jbms.application.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(TagController.class)
public class TagControllerMvcTest extends AbstractMT {

    @MockitoBean
    TagService tagService;

    @Test
    void getToTagsEndpointReturns200Ok() {
        mockMvcTester.perform(get("/tags"))
                .assertThat()
                .hasStatus2xxSuccessful();
    }

    @Test
    void getToTagsEndpointBasedOnSearchTextReturns200Ok() {
        mockMvcTester.perform(get("/tags")
                        .param("searchText","search"))
                .assertThat()
                .hasStatus2xxSuccessful();
    }
}
