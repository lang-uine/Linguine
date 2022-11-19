package com.Linguine.repository;

import com.Linguine.domain.member.Member;
import com.Linguine.service.MemberService;
import com.Linguine.service.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @Test
    public void MemberRepositoryTest() throws Exception {
        //given
        Member member = Member.builder()
                .name("kim")
                .nickName("kimNick")
                .password(new BCryptPasswordEncoder().encode("123"))
                .email("123@naver.com")
                .build();
        String savedE = member.getEmail();
        //when
        Member judge = memberRepository.findByEmail(savedE).get();

        //then
        System.out.println("savedE = " + savedE);
        System.out.println("judge = " + judge);
        System.out.println("memberService = " + memberService);;
        System.out.println("memberRepository = " + memberRepository);;
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(judge);

    }

}