package com.amalvadkar.jbms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@AllArgsConstructor
public class Bookmark {
    private String title;
    private String url;
    private Instant createdOnUtc;
    private List<Tag> tags;
}
