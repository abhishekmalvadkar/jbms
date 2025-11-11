package com.amalvadkar.jbms.adapter.in.web;

import com.amalvadkar.jbms.application.WelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WelcomeController {

    private final WelcomeService welcomeService;

    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("totalBookmarksCount", welcomeService.totalBookmarkCount());
        model.addAttribute("totalTagsCount", welcomeService.totalTagCount());
        return "welcome";
    }

}
