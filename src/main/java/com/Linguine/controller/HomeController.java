package com.Linguine.controller;

import com.Linguine.domain.member.CustomUserDetails;
import com.Linguine.domain.member.MemberAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final HttpSession httpSession;
    @GetMapping("/")
    public String home(@AuthenticationPrincipal MemberAdapter userAdapter, Model model) {
        if (userAdapter != null) {
            log.info("login User -> {}", userAdapter.toString());
            model.addAttribute("activeUserName", userAdapter.getMember().getName());
        } else {
            model.addAttribute("activeUserName", "게스트");
            log.info("No User Logined...");


        }



        return "index";
    }


}
