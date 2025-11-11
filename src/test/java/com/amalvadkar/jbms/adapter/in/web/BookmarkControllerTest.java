package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.adapter.out.InMemoryBookmarkRepository;
import com.amalvadkar.jbms.application.BookmarkService;
import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import com.amalvadkar.jbms.domain.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookmarkControllerTest {

    @Test
    void bookmarksReturnsBookmarksListAsViewName() {
        BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of());
        BookmarkService bookmarkService = new BookmarkService(bookmarkRepository);
        BookmarkController bookmarkController = new BookmarkController(bookmarkService);

        String viewName = bookmarkController.bookmarks(new ConcurrentModel(),null);

        assertThat(viewName).isEqualTo("bookmark-list");
    }

    @SuppressWarnings("unchecked")
    @Test
    void bookmarksReturnsModelWithEmptyListOfBookmarks() {
        BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of());
        BookmarkService bookmarkService = new BookmarkService(bookmarkRepository);
        BookmarkController bookmarkController = new BookmarkController(bookmarkService);
        Model model = new ConcurrentModel();

        bookmarkController.bookmarks(model,null);

        List<Bookmark> bookmarks = (List<Bookmark>) model.getAttribute("bookmarks");
        assertThat(bookmarks).isEmpty();
    }

    @SuppressWarnings("unchecked")
    @Test
    void bookmarksReturnsModelWithListOfBookmarks() {
        Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", LocalDate.now(), List.of());
        Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", LocalDate.now(), List.of());
        BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));
        BookmarkService bookmarkService = new BookmarkService(bookmarkRepository);
        BookmarkController bookmarkController = new BookmarkController(bookmarkService);
        Model model = new ConcurrentModel();

        bookmarkController.bookmarks(model,null);

        List<Bookmark> bookmarks = (List<Bookmark>) model.getAttribute("bookmarks");
        assertThat(bookmarks).hasSize(2);
    }

    @SuppressWarnings("unchecked")
    @Test
    void bookmarksReturnsModelWithListOfBookmarksWithDateWiseDescOrder() {
        Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", LocalDate.of(2024, 11, 10), List.of());
        Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", LocalDate.of(2025,10,11), List.of());
        BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));
        BookmarkService bookmarkService = new BookmarkService(bookmarkRepository);
        BookmarkController bookmarkController = new BookmarkController(bookmarkService);
        Model model = new ConcurrentModel();

        bookmarkController.bookmarks(model,null);

        List<Bookmark> bookmarks = (List<Bookmark>) model.getAttribute("bookmarks");
        assertThat(bookmarks).hasSize(2);
        assertThat(bookmarks.getFirst().getCreatedDate()).hasYear(2025);
    }

    @Test
    void bookmarksReturnsModelWithListOfBookmarksBasedOnTagWithDateWiseDescOrder() {
        Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", LocalDate.of(2024, 11, 10), List.of(new Tag("java")));
        Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", LocalDate.of(2025,10,11), List.of(new Tag("spring")));
        BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));
        BookmarkService bookmarkService = new BookmarkService(bookmarkRepository);
        BookmarkController bookmarkController = new BookmarkController(bookmarkService);
        Model model = new ConcurrentModel();

        bookmarkController.bookmarks(model,"java");

        List<Bookmark> bookmarks = (List<Bookmark>) model.getAttribute("bookmarks");
        assertThat(bookmarks).hasSize(1);
    }





}
