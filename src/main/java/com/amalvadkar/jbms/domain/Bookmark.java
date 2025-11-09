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
}
