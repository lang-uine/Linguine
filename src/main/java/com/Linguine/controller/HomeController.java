package com.Linguine.controller;

import com.Linguine.domain.member.Member;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {

        String activeUser =  (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(activeUser == null) {
            model.addAttribute("activeUserName", "게스트");
            return "index";
        }
        model.addAttribute("activeUserName",activeUser);

        return "index";
    }

//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }



}
