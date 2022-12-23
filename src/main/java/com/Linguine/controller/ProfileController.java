package com.Linguine.controller;

import com.Linguine.domain.member.Member;
import com.Linguine.domain.member.MemberAdapter;
import com.Linguine.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final MemberService memberService;

    @RequestMapping("profile/get/")
    public String getProfile(Model model, @RequestParam("id") Long id, @AuthenticationPrincipal MemberAdapter memberAdapter) {
        Member found = memberService.findById(id).get();
        model.addAttribute("member", found);
        return "profile";

    }
}
