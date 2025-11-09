package com.amalvadkar.jbms.application.port;

import com.amalvadkar.jbms.domain.Bookmark;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookMarkRepository;

    public List<Bookmark> bookmarks(){
        return bookMarkRepository.allBookmarks();
    }
}
