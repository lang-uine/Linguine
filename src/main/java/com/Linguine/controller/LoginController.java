package com.Linguine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/register")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "/members/register";
    }

//    @RequestMapping("/login")
//    public String login(Model model) {
////        model.addAttribute("userInfo", @RequestParam("user") Member member);
//    }
}
