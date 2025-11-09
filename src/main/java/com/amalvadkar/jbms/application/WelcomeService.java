package com.amalvadkar.jbms.application;

import com.amalvadkar.jbms.application.port.BookmarkRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WelcomeService {

    private final BookmarkRepository bookmarkRepository;

    public int totalBookmarkCount() {
        return bookmarkRepository.allBookmarks().size();
    }
}
