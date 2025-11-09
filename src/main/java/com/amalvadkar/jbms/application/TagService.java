package com.amalvadkar.jbms.application;

import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import com.amalvadkar.jbms.domain.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TagService {

    private final BookmarkRepository bookmarkRepository;

    public List<Tag> tags() {
        List<Bookmark> bookmarks = bookmarkRepository.allBookmarks();
        return bookmarks.stream()
                .flatMap(bookmark -> bookmark.getTags().stream())
                .distinct()
                .toList();
    }

}
