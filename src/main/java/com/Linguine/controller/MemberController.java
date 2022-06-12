package com.Linguine.controller;

import com.Linguine.domain.member.Member;
import com.Linguine.service.MemberService;
import com.Linguine.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "/members/memberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {
        Member member = new Member();
        member.setName(form.getName());
        member.setPublic_Id(form.getPublic_id());
        member.setNickName(form.getNickName());
        member.setPassword(form.getPassword());
        member.setPh(form.getPh());
        member.setEmail(form.getEmail());
        memberService.join(member);

        return "redirect:/";
    }
}
