package com.Linguine.controller;

import com.Linguine.config.auth.SecurityConfig;
import com.Linguine.domain.member.Member;
import com.Linguine.domain.member.MemberAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal MemberAdapter memberAdapter, Model model) {
        if (memberAdapter != null) {
            log.info("[HomeController] login User -> {}", memberAdapter.getUsername());
            model.addAttribute("activeUser", memberAdapter.getMember());
        } else {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication != null) {
                model.addAttribute("activeUser", "admin");
                /**
                 * 2022-12-08
                 * by yeoooo
                 *
                 * 개발용 관리자 계정
                 */
            }else{
                model.addAttribute("activeUser", "게스트");
            }
            log.info("[HomeController] Guest Logined");
        }

        return "index";
    }


}
