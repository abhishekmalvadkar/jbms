package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.application.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.util.Objects.isNull;

@Controller
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping("/bookmarks")
    public String bookmarks(Model model,  @RequestParam(value = "tagName", required = false) String tagName){
        if (isNull(tagName)) {
            model.addAttribute("bookmarks", bookmarkService.bookmarks());
        } else {
            model.addAttribute("bookmarks", bookmarkService.bookmarks(tagName));
        }
        return "bookmark-list";
    }
}
