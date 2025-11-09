package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.application.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/tags")
    public String tags(Model model){
        model.addAttribute("tags",tagService.tags());
        return "tag-list";
    }
}
