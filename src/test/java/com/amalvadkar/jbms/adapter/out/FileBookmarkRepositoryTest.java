package com.amalvadkar.jbms.adapter.out;

import com.amalvadkar.jbms.adapter.in.web.common.AbstractIT;
import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileBookmarkRepositoryTest extends AbstractIT {

    @Autowired
    BookmarkRepository bookmarkRepository;

    @ParameterizedTest
    @ValueSource(strings = {
            "https://tinyurl.com/bdcdvrj7",
            "https://tinyurl.com/bd9sf5h3"
    })
    void shouldOnlyOneBookmarkExistsWithGivenUrl(String bookmarkUrl) {
        List<Bookmark> bookmarks = bookmarkRepository.byUrl(bookmarkUrl);
        assertThat(bookmarks).hasSize(1);
    }
}