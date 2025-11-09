package com.amalvadkar.jbms;

import com.amalvadkar.jbms.adapter.out.InMemoryBookmarkRepository;
import com.amalvadkar.jbms.application.TagService;
import com.amalvadkar.jbms.application.WelcomeService;
import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.application.port.BookmarkService;
import com.amalvadkar.jbms.domain.Bookmark;
import com.amalvadkar.jbms.domain.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.List;

@Configuration
public class JbmsConfig {

    @Bean
    public BookmarkService bookmarkService(){
        Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", Instant.now(), List.of(new Tag("spring"), new Tag("java"), new Tag("jdbc")));
        Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", Instant.now(), List.of(new Tag("mysql"), new Tag("ssh"), new Tag("jdbc")));
        BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));
        return new BookmarkService(bookmarkRepository);
    }

    @Bean
    public WelcomeService welcomeService(){
        Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", Instant.now(), List.of(new Tag("spring"), new Tag("java"), new Tag("jdbc")));
        Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", Instant.now(), List.of(new Tag("mysql"), new Tag("ssh"), new Tag("jdbc")));
        BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));
        return new WelcomeService(bookmarkRepository);
    }

    @Bean
    public TagService tagService(){
        Bookmark bookmarkOne = new Bookmark("Bookmark 1", "Bookmark 1 url", Instant.now(), List.of(new Tag("spring"), new Tag("java"), new Tag("jdbc")));
        Bookmark bookmarkTwo = new Bookmark("Bookmark 2", "Bookmark 2 url", Instant.now(), List.of(new Tag("mysql"), new Tag("ssh"), new Tag("jdbc")));
        BookmarkRepository bookmarkRepository = new InMemoryBookmarkRepository(List.of(bookmarkOne, bookmarkTwo));
        return new TagService(bookmarkRepository);
    }

}
