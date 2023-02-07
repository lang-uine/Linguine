package com.Linguine.controller;

import com.Linguine.domain.board.Category;
import com.Linguine.domain.member.MemberAdapter;
import com.Linguine.domain.member.Role;
import com.Linguine.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
	
	private final BoardRepository boardRepository;

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
                log.info("[HomeController] Admin Logged in");
            }else{
                model.addAttribute("activeUser", null);
                log.info("[HomeController] Guest Logged in");
            }
        } else {
            model.addAttribute("activeUser", memberAdapter.getMember());

            log.info("[HomeController] User Logged in");

        }
        
        model.addAttribute("ROLES", Role.values());
        model.addAttribute("HOT", boardRepository.findHotBoard());
        model.addAttribute("FREE", boardRepository.findByCategory(Category.Free));
        model.addAttribute("REVIEW", boardRepository.findByCategory(Category.Review));
        model.addAttribute("TRADE", boardRepository.findByCategory(Category.Trade));
        
        
        return "index";

    }


}
