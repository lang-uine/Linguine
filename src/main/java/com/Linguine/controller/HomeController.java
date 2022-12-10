package com.Linguine.controller;

import com.Linguine.domain.member.MemberAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.text.html.Option;
import java.util.Optional;


@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal Optional<MemberAdapter> memberAdapter, Model model) {
//        if (memberAdapter != null) {
//            log.info("[HomeController] login User -> {}", memberAdapter.getUsername());
//            model.addAttribute("activeUser", memberAdapter.getMember());
//        } else {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            System.out.println("authentication = " + authentication);
//
//            if (authentication != null) {
//                model.addAttribute("activeUser", "admin");
//                /**
//                 * 2022-12-08
//                 * by yeoooo
//                 *
//                 * 개발용 관리자 계정
//                 */
//            }else{
//                model.addAttribute("activeUser", "게스트");
//            }
//            log.info("[HomeController] Guest Logined");
//        }
//        memberAdapter.map(x -> x != null)
//                        .map(x -> model.addAttribute("activeUser", x))
//                        .orElseGet((Supplier<? extends Model>) SecurityContextHolder.getContext().getAuthentication())
//
        MemberAdapter activeUser = memberAdapter.orElse((MemberAdapter) SecurityContextHolder.getContext().getAuthentication());
//                \filter(x -> x != null)
//                .orElseGet(() -> ;

        model.addAttribute("activeUser", activeUser);


        return "index";
    }


}
