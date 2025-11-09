package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.application.port.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping("/bookmarks")
    public String bookmarks(Model model){
        model.addAttribute("bookmarks", bookmarkService.bookmarks());
        return "bookmark-list";
    }
}
