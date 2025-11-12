package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.application.TagService;
import com.amalvadkar.jbms.domain.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/tags")
    public String tags(Model model, @RequestParam(value = "searchText", required = false) String searchText) {
        if(Objects.nonNull(searchText) && searchText.isEmpty()) model.addAttribute("validationMessage","Search text is required");
        if(Objects.nonNull(searchText) &&!searchText.isEmpty()) model.addAttribute("searchText", searchText);
        List<Tag> tags = tagService.findTags(searchText);
        model.addAttribute("tags", tags);
        model.addAttribute("tagsCount",tags.size());
        return "tag-list";
    }

}
