package com.Linguine.controller;

import com.Linguine.domain.member.Member;
import com.Linguine.domain.member.MemberDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(@AuthenticationPrincipal MemberDTO memberDTO, Model model) {

        if(memberDTO == null) {
            model.addAttribute("activeUserName", "게스트");
            return "index";
        }
        model.addAttribute("activeUserName", memberDTO.getMember().getNickName());
        return "index";
    }



}
