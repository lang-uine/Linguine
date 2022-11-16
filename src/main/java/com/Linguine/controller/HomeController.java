package com.Linguine.controller;

import com.Linguine.domain.member.CustomUserDetails;
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
    public String home(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {

        if (userDetails != null) {
            log.info("login User -> {}", userDetails.toString());
            model.addAttribute("activeUserName", userDetails.getMember().getName());
        } else {
            log.info("No user Accessed");
            model.addAttribute("activeUserName", "게스트");
        }



        return "index";
    }


}
