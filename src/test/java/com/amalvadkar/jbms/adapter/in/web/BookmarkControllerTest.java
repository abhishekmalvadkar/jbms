package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.domain.Bookmark;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookmarkControllerTest {

    @SuppressWarnings("unchecked")
    @Test
    void bookmarksReturnsModelWithEmptyListOfBookmarks() {
        BookmarkController bookmarkController = new BookmarkController();
        Model model = new ConcurrentModel();

        String viewName = bookmarkController.bookmarks(model);

        assertThat(viewName).isEqualTo("bookmark-list");
        List<Bookmark> bookmarks = (List<Bookmark>) model.getAttribute("bookmarks");
        assertThat(bookmarks).isEmpty();
    }
}
