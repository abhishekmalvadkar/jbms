package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.adapter.out.InMemoryBookmarkRepository;
import com.amalvadkar.jbms.application.WelcomeService;
import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WelcomeControllerTest {

    @Test
    void welcomeShouldReturnTotalBookmarkCountInModelWithWelcomeViewName() {
        Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", Instant.now(), List.of());
        Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", Instant.now(), List.of());
        BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));
        WelcomeService welcomeService = new WelcomeService(bookmarkRepository);
        WelcomeController welcomeController = new WelcomeController(welcomeService);

        Model model = new ConcurrentModel();
        String viewName = welcomeController.welcome(model);

        assertThat(viewName).isEqualTo("welcome");
        assertThat(model.getAttribute("totalBookmarksCount")).isEqualTo(2);
    }
}