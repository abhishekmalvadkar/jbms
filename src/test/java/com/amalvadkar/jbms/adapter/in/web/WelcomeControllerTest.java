package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.adapter.out.InMemoryBookmarkRepository;
import com.amalvadkar.jbms.application.WelcomeService;
import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import com.amalvadkar.jbms.domain.Tag;
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

    @Test
    void welcomeShouldReturnTotalTagCountInModel() {
        Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", Instant.now(), List.of(new Tag("spring"), new Tag("java"), new Tag("jdbc")));
        Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", Instant.now(), List.of(new Tag("mysql"), new Tag("ssh"), new Tag("jdbc")));
        BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));
        WelcomeService welcomeService = new WelcomeService(bookmarkRepository);
        WelcomeController welcomeController = new WelcomeController(welcomeService);

        Model model = new ConcurrentModel();
        welcomeController.welcome(model);

        assertThat(model.getAttribute("totalTagsCount")).isEqualTo(5);
    }
}