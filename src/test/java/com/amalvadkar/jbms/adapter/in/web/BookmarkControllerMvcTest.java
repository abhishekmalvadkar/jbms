package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.adapter.in.web.common.AbstractMT;
import com.amalvadkar.jbms.application.BookmarkService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(BookmarkController.class)
public class BookmarkControllerMvcTest extends AbstractMT {

    @MockitoBean
    BookmarkService bookmarkService;

    @Test
    void getToBookmarksEndpointReturns200Ok() {
        mockMvcTester.perform(get("/bookmarks"))
                .assertThat()
                .hasStatus2xxSuccessful();
    }

    @Test
    void getToBookmarksBasedOnTagEndpointReturns200() {
        mockMvcTester.perform(get("/bookmarks")
                        .param("tagName","java"))
                .assertThat()
                .hasStatus2xxSuccessful();
    }
}
