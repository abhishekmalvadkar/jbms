package com.amalvadkar.jbms.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Tag {
    private String name;

    public boolean tagNameContains(String tagNamePart) {
        return name.toLowerCase().contains(tagNamePart.toLowerCase());
    }
}
