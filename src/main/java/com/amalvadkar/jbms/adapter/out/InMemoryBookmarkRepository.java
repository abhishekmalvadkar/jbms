package com.amalvadkar.jbms.adapter.out;

import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class InMemoryBookmarkRepository implements BookmarkRepository {

    private final List<Bookmark> bookmarks;

    @Override
    public List<Bookmark> allBookmarks() {
         return bookmarks.stream()
                .sorted(Comparator.comparing(Bookmark::getCreatedDate).reversed())
                .toList();
    }

    @Override
    public List<Bookmark> byUrl(String url) {
        return bookmarks.stream()
                .filter(bookmark -> bookmark.getUrl().equals(url))
                .toList();
    }
}
