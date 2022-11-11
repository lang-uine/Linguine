package com.Linguine.controller;

import com.Linguine.config.auth.CustomUserDetailsService;
import com.Linguine.config.auth.SessionMember;
import com.Linguine.domain.member.Member;
import com.Linguine.domain.member.MemberAdapter;
import com.Linguine.domain.member.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal MemberDTO memberDTO, Model model) {
//        SessionMember oauthMember = (SessionMember) httpSession.getAttribute("user");

        System.out.println("memberAdapter = " + memberDTO);
//        if (oauthMember != null) {
//            model.addAttribute("activeUserName", oauthMember.getName());
//            System.out.println("oauthMember = " + oauthMember.getName());
//
//
//        }
        if (memberDTO == null) {
            model.addAttribute("activeUserName", "게스트");
            return "index";
        }
        model.addAttribute("activeUserName", memberDTO.getMember().getNickName());
        log.info("login : {}", memberDTO);
        return "index";
    }


}
