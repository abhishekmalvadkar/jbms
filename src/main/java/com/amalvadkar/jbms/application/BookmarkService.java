package com.amalvadkar.jbms.application;

import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookMarkRepository;

    public List<Bookmark> bookmarks() {
        return bookMarkRepository.allBookmarks();
    }

    public List<Bookmark> bookmarks(String tagName) {
        return bookMarkRepository.allBookmarks().stream()
                .filter(by(tagName))
                .toList();
    }

    private static Predicate<Bookmark> by(String tagName) {
        return bookmark -> bookmark.has(tagName);
    }
}
