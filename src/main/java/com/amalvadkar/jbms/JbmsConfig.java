package com.amalvadkar.jbms;

import com.amalvadkar.jbms.adapter.out.InMemoryBookmarkRepository;
import com.amalvadkar.jbms.application.port.BookmarkRepository;
import com.amalvadkar.jbms.application.port.BookmarkService;
import com.amalvadkar.jbms.domain.Bookmark;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class JbmsConfig {

    @Bean
    public BookmarkService bookmarkService(){
        List<Bookmark> bookmarks = List.of();
        BookmarkRepository bookMarkRepository = new InMemoryBookmarkRepository(bookmarks);
        return new BookmarkService(bookMarkRepository);
    }

}
