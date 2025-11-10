package com.amalvadkar.jbms.adapter.out;

import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class FileBookmarkRepository implements BookmarkRepository {

    private final BookmarkStore bookmarkStore;

    @Override
    public List<Bookmark> allBookmarks() {
       return bookmarkStore.bookmarks().stream()
                .sorted(Comparator.comparing(Bookmark::getCreatedDate).reversed())
                .toList();
    }

    @Override
    public List<Bookmark> byUrl(String url) {
        return bookmarkStore.bookmarks()
                .stream()
                .filter(bookmark -> bookmark.getUrl().equals(url))
                .toList();
    }
}
