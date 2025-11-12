package com.amalvadkar.jbms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class Bookmark {
    private String title;
    private String url;
    private LocalDate createdDate;
    private List<Tag> tags;

    public boolean containsTitle(String bookmarkTitlePart) {
        return title.toLowerCase().contains(bookmarkTitlePart.toLowerCase());
    }

    public boolean has(String tagName){
        return tags.stream()
                .anyMatch(tag -> tag.getName().equals(tagName));
    }
    public boolean containsTagName(String tagNamePart){
        return tags.stream()
                .anyMatch(tag -> tag.getName().toLowerCase().contains(tagNamePart.toLowerCase()));

    }
}
