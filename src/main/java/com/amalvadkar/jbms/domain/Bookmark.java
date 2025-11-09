package com.amalvadkar.jbms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class Bookmark {
    private String title;
    private String url;
    private ZonedDateTime createdOn;
    private List<Tag> tags;
}
