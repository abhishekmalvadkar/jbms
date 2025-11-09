package com.amalvadkar.jbms;

import com.amalvadkar.jbms.application.BookmarkService;
import com.amalvadkar.jbms.application.TagService;
import com.amalvadkar.jbms.application.WelcomeService;
import com.amalvadkar.jbms.application.port.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JbmsConfig {

    private final BookmarkRepository bookmarkRepository;

    @Bean
    public BookmarkService bookmarkService(){
        return new BookmarkService(bookmarkRepository);
    }

    @Bean
    public WelcomeService welcomeService(){
        return new WelcomeService(bookmarkRepository);
    }

    @Bean
    public TagService tagService(){
        return new TagService(bookmarkRepository);
    }

}
