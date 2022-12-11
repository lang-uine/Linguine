package com.Linguine.controller;

import com.Linguine.domain.member.MemberAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;


@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal Authentication admin, @AuthenticationPrincipal MemberAdapter memberAdapter, Model model) {

        if (memberAdapter == null) {
            if (admin != null) {
                /**
                 * 2022-12-08
                 * by yeoooo
                 *
                 * 개발용 관리자 계정
                 */
                model.addAttribute("activeUser", admin);
                log.info("[HomeController] Admin Logined");
            }else{
                model.addAttribute("activeUser", null);
                log.info("[HomeController] Guest Logined");
            }
        } else {
            model.addAttribute("activeUser", memberAdapter);
            log.info("[HomeController] User Logined");
        }
        return "index";

    }


}
