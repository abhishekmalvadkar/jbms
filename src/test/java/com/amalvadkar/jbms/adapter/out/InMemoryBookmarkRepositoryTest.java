package com.amalvadkar.jbms.adapter.out;

import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryBookmarkRepositoryTest {

    @Test
    void allBookmarks() {
        Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", LocalDate.now(), List.of());
        Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", LocalDate.now(), List.of());
        BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));

        List<Bookmark> bookmarks = bookmarkRepository.allBookmarks();

        assertThat(bookmarks).hasSize(2);
    }

    @Test
    void byUrl() {
        Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", LocalDate.now(), List.of());
        Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", LocalDate.now(), List.of());
        BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));

        List<Bookmark> bookmarks = bookmarkRepository.byUrl("Bookmark 2 url");

        assertThat(bookmarks).hasSize(1);
    }
}