package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.application.port.BookmarkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(BookmarkController.class)
public class BookmarkControllerMvcTest {

    @Autowired
    MockMvcTester mockMvcTester;

    @MockitoBean
    BookmarkService bookmarkService;

    @Test
    void getToBookmarksEndpointReturns200() {
        mockMvcTester.perform(get("/bookmarks"))
                .assertThat()
                .hasStatus2xxSuccessful();
    }
}
