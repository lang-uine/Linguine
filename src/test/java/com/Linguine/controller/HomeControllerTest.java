package com.Linguine.controller;

import com.Linguine.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HomeControllerTest {


    @Test
    public void login() throws Exception {
        //given
        Member activeUser = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //when
        System.out.println("activeUser = " + activeUser);

        //then

    }

}