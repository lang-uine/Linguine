package com.Linguine.controller;

import com.Linguine.domain.member.Member;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class LoginController{

    @GetMapping("/login")
    public String getLoginPage(Model model,
                               @RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "exception", required = false) String exception) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "/members/login";
    }

//    @PostMapping("/login/action")
//    public String ll(Model model) {
//        System.out.println("gdgdgdgdgdgd");
//        Member activeUser = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("activeUser = " + activeUser);
//        return "redirect:/";
//    }
}
