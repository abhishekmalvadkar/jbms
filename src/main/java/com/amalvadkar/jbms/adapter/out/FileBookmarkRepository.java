package com.amalvadkar.jbms.adapter.out;

import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class FileBookmarkRepository implements BookmarkRepository {

    private final BookmarkStore bookmarkStore;

    @Override
    public List<Bookmark> allBookmarks() {
        return bookmarkStore.bookmarks();
    }
}
