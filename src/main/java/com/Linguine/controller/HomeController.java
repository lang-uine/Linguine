package com.Linguine.controller;

import com.Linguine.domain.member.MemberAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal MemberAdapter memberAdapter, Model model) {
        if (memberAdapter != null) {
            log.info("login User -> {}", memberAdapter.getUsername());
            model.addAttribute("activeUserName", memberAdapter.getMember().getName());
        } else {
            model.addAttribute("activeUserName", "게스트");
            log.info("Guest Login");
        }

        return "index";
    }


}
