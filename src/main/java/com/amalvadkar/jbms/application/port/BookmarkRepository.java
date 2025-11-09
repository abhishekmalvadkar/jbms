package com.amalvadkar.jbms.application.port;

import com.amalvadkar.jbms.domain.Bookmark;

import java.util.List;

public interface BookmarkRepository {
    List<Bookmark> allBookmarks();
}
