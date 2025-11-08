package com.amalvadkar.jbms.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("welcomeMessage", "Welcome to JBMS");
        model.addAttribute("totalBookmarksCount", 2);
        model.addAttribute("totalTagsCount", 3);
        return "welcome";
    }

}
