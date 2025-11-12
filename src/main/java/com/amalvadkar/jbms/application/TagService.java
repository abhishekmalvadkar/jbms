package com.amalvadkar.jbms.application;

import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import com.amalvadkar.jbms.domain.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class TagService {

    private final BookmarkRepository bookmarkRepository;

    public List<Tag> allTags() {
        List<Bookmark> bookmarks = bookmarkRepository.allBookmarks();
        return bookmarks.stream()
                .flatMap(bookmark -> bookmark.getTags().stream())
                .distinct()
                .toList();

    }

    public List<Tag> tagsBySearchText(String searchText) {
        return allTags().stream()
                .filter(ifTagNameContains(searchText))
                .toList();
    }

    private static Predicate<Tag> ifTagNameContains(String searchText) {
        return tag -> tag.tagNameContains(searchText);
    }

    public List<Tag> findTags(String searchText) {
        if (nonNull(searchText)) {
            return tagsBySearchText(searchText);
        } else {
            return allTags();
        }
    }
}
