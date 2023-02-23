package com.Linguine.service;

import com.Linguine.domain.member.Member;
import com.Linguine.domain.member.Role;
import com.Linguine.service.MemberService;
import com.Linguine.service.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("회원 가입 테스트")
    public void JoinTest() throws Exception {
        //given
        Member member = Member.builder()
                .name("kim")
                .nickName("kimNick")
                .password(new BCryptPasswordEncoder().encode("12345"))
                .email("123@naver.com")
                .role(Role.USER)
                .build();

        memberService.join(member);
        long saved = member.getId();
        //when
        Member judge = memberService.findById(saved).orElseThrow(() -> new NoSuchElementException());

        //then
        org.assertj.core.api.Assertions.assertThat(member.getId()).isEqualTo(judge.getId());

    }

}