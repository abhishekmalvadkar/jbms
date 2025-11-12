package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.adapter.out.InMemoryBookmarkRepository;
import com.amalvadkar.jbms.application.TagService;
import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.domain.Bookmark;
import com.amalvadkar.jbms.domain.Tag;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TagControllerTest {

    @Nested
    class TagListFeature {

        @SuppressWarnings("unchecked")
        @Test
        void tagsShouldReturnModelWithTags() {
            Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", LocalDate.now(), List.of());
            Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", LocalDate.now(), List.of());
            BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));
            TagService tagService = new TagService(bookmarkRepository);
            TagController tagController = new TagController(tagService);
            Model concurrentModel = new ConcurrentModel();

            tagController.tags(concurrentModel,null);

            List<Tag> tags = (List<Tag>) concurrentModel.getAttribute("tags");
            assertThat(tags).isEmpty();
        }

        @Test
        void tagsShouldReturnModelWithTagCount() {
            Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", LocalDate.now(), List.of(new Tag("Spring")));
            Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", LocalDate.now(), List.of(new Tag("jdbc")));
            BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));
            TagService tagService = new TagService(bookmarkRepository);
            TagController tagController = new TagController(tagService);
            Model concurrentModel = new ConcurrentModel();

            tagController.tags(concurrentModel, "");

            assertThat(concurrentModel.getAttribute("tagsCount")).isEqualTo(2);
        }
    }

    @Nested
    class TagSearchFeature {

        @SuppressWarnings("unchecked")
        @Test
        void tagsShouldReturnModelWithTagsBasedOnSearchText() {
            Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", LocalDate.now(), List.of(new Tag("Spring")));
            Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", LocalDate.now(), List.of(new Tag("jdbc")));
            BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));
            TagService tagService = new TagService(bookmarkRepository);
            TagController tagController = new TagController(tagService);
            Model concurrentModel = new ConcurrentModel();

            tagController.tags(concurrentModel, "bc");

            List<Tag> tags = (List<Tag>) concurrentModel.getAttribute("tags");
            assertThat(tags).hasSize(1);
        }

        @SuppressWarnings("unchecked")
        @Test
        void tagsShouldReturnModelWithTagsBasedOnSearchTextIfSearchTextEmpty() {
            Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", LocalDate.now(), List.of(new Tag("Spring")));
            Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", LocalDate.now(), List.of(new Tag("jdbc")));
            BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));
            TagService tagService = new TagService(bookmarkRepository);
            TagController tagController = new TagController(tagService);
            Model concurrentModel = new ConcurrentModel();

            tagController.tags(concurrentModel, "");

            List<Tag> tags = (List<Tag>) concurrentModel.getAttribute("tags");
            assertThat(tags).hasSize(2);
            assertThat(concurrentModel.getAttribute("validationMessage")).isEqualTo("Search text is required");
        }
    }
}
