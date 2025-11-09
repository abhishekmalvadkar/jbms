package com.amalvadkar.jbms.adapter.out;

import com.amalvadkar.jbms.domain.Bookmark;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "jbms.store")
public record BookmarkStore(List<Bookmark> bookmarks) {
}
