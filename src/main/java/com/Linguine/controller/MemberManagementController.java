package com.Linguine.controller;

import com.Linguine.domain.member.Member;
import com.Linguine.domain.member.MemberAdapter;
import com.Linguine.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberManagementController {

    private final MemberService memberService;


    @GetMapping("/management/member")
    public String getMembers(@AuthenticationPrincipal MemberAdapter memberAdapter, Model model, int period) {
        List<Member> memberList = memberService.findAll();
        model.addAttribute("members", memberList);
        model.addAttribute("activeUser", memberAdapter.getMember());
        model.addAttribute("period", period);

        return "management/memberManagement";
    }

    @RequestMapping("/management/member/delete")
    public String deleteMember(@AuthenticationPrincipal MemberAdapter memberAdapter, @RequestParam("id") Long id) {
        memberService.deleteById(id);
        log.info("[MemberManagementController] Member Deleted Id => {}", id);
        return "redirect:/management/member";
    }

    @RequestMapping("/management/member/suspend/{id}")
    public String suspendMember(@AuthenticationPrincipal MemberAdapter memberAdapter, @PathVariable("id") Long id, int period) {
        Member found = memberService.findById(id).get();
        found.suspend(period);
        log.info("[MemberManagementController] Member ID - {} is Suspended.", id);
        return "redirect:";
    }
}
