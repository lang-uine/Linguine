package com.Linguine.controller;

import com.Linguine.domain.member.Member;
import com.Linguine.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final MemberService memberService;

    @PostMapping("/register")
    public String register(@Valid MemberForm form, BindingResult result) {
        Member member = new Member();
        member.setPublic_Id(form.getPublic_id());
        member.setNickName(form.getNickName());
        member.setPassword(form.getPassword());
        member.setPh(form.getPh());
        member.setEmail(form.getEmail());
        memberService.join(member);
        return "redirect:/";
    }
}
