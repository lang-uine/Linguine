package com.Linguine.controller;

import com.Linguine.domain.member.Member;
import com.Linguine.domain.member.MemberForm;
import com.Linguine.domain.member.Role;
import com.Linguine.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/register";
    }

    @PostMapping("/register")
    public String register(@Valid MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "members/register";
        }
        Member member = Member.builder()
                .name(form.getName())
                .nickName(form.getNickName())
                .email(form.getEmail())
                .role(Role.USER)
                .password(new BCryptPasswordEncoder().encode(form.getPassword()))
                .lastLoginTime(LocalDateTime.now())
                .build();
        memberService.validateDuplicateNickName(member);
        memberService.validateDuplicateEmail(member);

        memberService.join(member);
        return "redirect:/";

    }

    @GetMapping("password")
    public String password(Model model) {
        return "/members/password";
    }

}
