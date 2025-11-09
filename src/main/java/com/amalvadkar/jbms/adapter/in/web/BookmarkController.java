package com.amalvadkar.jbms.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookmarkController {

    @GetMapping("/bookmarks")
    public String bookmarks(Model model){
        model.addAttribute("bookmarks", List.of());
        return "bookmark-list";
    }
}
