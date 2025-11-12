package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.application.BookmarkService;
import com.amalvadkar.jbms.domain.Bookmark;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping("/bookmarks")
    public String bookmarks(Model model,
                            @RequestParam(value = "tagName", required = false) String tagName,
                            @RequestParam(value = "searchText", required = false) String searchText) {
        if( Objects.nonNull(searchText) && searchText.isEmpty()) model.addAttribute("validationMessage","Search text is required");
        if(Objects.nonNull(searchText) &&!searchText.isEmpty()) model.addAttribute("searchText", searchText);
        List<Bookmark> bookmarks = bookmarkService.findBookmarks(tagName, searchText);
        model.addAttribute("bookmarks", bookmarks);
        model.addAttribute("bookmarksCount", bookmarks.size());
        return "bookmark-list";
    }
}
