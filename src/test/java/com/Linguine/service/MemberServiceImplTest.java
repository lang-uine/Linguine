package com.Linguine.service;

import com.Linguine.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {
//
    @Autowired
    MemberService memberService;

    @Test
    public void MemberServiceImplTest() throws Exception {
        //given
        Member member = Member.builder()
                .email("123@naver.com")
                .name("kim")
                .nickName("helloworld")
                .password("asdasd")
                .build();
        //when
        System.out.println("member = " + member.toString());
        //then

    }
}