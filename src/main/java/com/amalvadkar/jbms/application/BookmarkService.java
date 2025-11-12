package com.amalvadkar.jbms.application;

import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookMarkRepository;

    public List<Bookmark> allBookmarks() {
        return bookMarkRepository.allBookmarks();
    }

    public List<Bookmark> bookmarksBySearchText(String searchText) {
         return bookMarkRepository.allBookmarks().stream()
                  .filter(ifBookmarkTitleContains(searchText).or(ifBookmarksTagContains(searchText)))
                  .toList();
    }

    private static Predicate<Bookmark> ifBookmarksTagContains(String searchText) {
        return bookmark -> bookmark.containsTagName(searchText);
    }

    private static Predicate<Bookmark> ifBookmarkTitleContains(String searchText) {
        return bookmark -> bookmark.containsTitle(searchText);
    }

    public List<Bookmark> bookmarksByTagName(String tagName) {
        return bookMarkRepository.allBookmarks().stream()
                .filter(by(tagName))
                .toList();
    }

    private static Predicate<Bookmark> by(String tagName) {
        return bookmark -> bookmark.has(tagName);
    }

    public List<Bookmark> findBookmarks(String tagName, String searchText) {
        if (userSelectedAny(tagName)) {
            return bookmarksByTagName(tagName);
        } else if (userSearchedBy(searchText)) {
            return bookmarksBySearchText(searchText);
        } else {
            return allBookmarks();
        }
    }

    private static boolean userSearchedBy(String searchText) {
        return nonNull(searchText);
    }

    private static boolean userSelectedAny(String tagName) {
        return nonNull(tagName);
    }
}
