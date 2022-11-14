package com.Linguine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userDetails, Model model) {
//        SessionMember oauthMember = (SessionMember) httpSession.getAttribute("user");
//        if (authentication == null) {
//            model.addAttribute("activeUserName", "게스트");
//        }else{
//            UserDetails userDetails1 = (CustomUserDetails) authentication.getPrincipal();
//            userDetails1.getUsername()

//            System.out.println("authentication.getName() = " + userDetails1.getUsername());
//            z
        if (userDetails != null) {
            log.info("login User -> {}", userDetails.toString());
        } else {
            log.info("No user Accessed");
            model.addAttribute("activeUserName", "게스트");
        }



        return "index";
    }


}
