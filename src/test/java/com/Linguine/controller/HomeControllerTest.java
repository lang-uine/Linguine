package com.Linguine.controller;

import com.Linguine.domain.member.Member;
import com.Linguine.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@Slf4j
class HomeControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    private MockMvc mvc;

    @BeforeEach
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .apply(springSecurity())
                .build();
//        }
    }

    @Test
    @DisplayName("Login 성공 테스트")
    public void login_success_test() throws Exception {
        // given
        String userId = "admin";
        String password = "admin";

        // when
        mvc.perform(formLogin()

                .loginProcessingUrl("/login/action")//2022-02-23_yeoooo:로그인 프로세싱 url과 로그인 페이지는 다르다
                .userParameter("inputEmail")
                .user(userId)
                .passwordParam("inputPassword")

                .password(password))

                .andDo(print())
                // then
                .andExpect(authenticated());
    }
    @Test
    @DisplayName("Login 실패 테스트")
    public void login_failure_test() throws Exception {
        // given
        String userId = "admin";
        String password = "1";

        // when
        mvc.perform(formLogin()

                .loginProcessingUrl("/login/action")//2022-02-23_yeoooo:로그인 프로세싱 url과 로그인 페이지는 다르다
                .userParameter("inputEmail")
                .user(userId)
                .passwordParam("inputPassword")

                .password(password))

                .andDo(print())
                // then
                .andExpect(unauthenticated());
    }


}