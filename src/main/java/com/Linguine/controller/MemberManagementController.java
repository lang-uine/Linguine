package com.Linguine.controller;

import com.Linguine.domain.member.Member;
import com.Linguine.domain.member.MemberAdapter;
import com.Linguine.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberManagementController {

    private final MemberService memberService;


    @GetMapping("/management/member")
    public String getMembers(@AuthenticationPrincipal MemberAdapter memberAdapter, Model model) {
        List<Member> memberList = memberService.findAll();
        model.addAttribute("members", memberList);
        model.addAttribute("activeUserName", memberAdapter.getMember().getName());


        return "management/memberManagement";
    }
}
