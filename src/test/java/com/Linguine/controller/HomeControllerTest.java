//package com.Linguine.controller;
//
//import com.Linguine.domain.member.Member;
//import com.Linguine.domain.member.Role;
//import com.Linguine.repository.MemberRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@Slf4j
//class HomeControllerTest {
//
//    @Autowired
//    private WebApplicationContext context;
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    BCryptPasswordEncoder passwordEncoder;
//
//    private MockMvc mvc;
//
//    @BeforeEach
//    public void setup(){
//        mvc = MockMvcBuilders
//                .webAppContextSetup(this.context)
//                .apply(springSecurity())
//                .build();
//
//        Member member = new Member(3L, "test11@test.com","tes1","test1","test1",passwordEncoder.encode("1234"), null, Role.USER);
//        memberRepository.save(member);
//    }
//
//    @Test
//    @DisplayName("Login 테스트")
//    public void login_test() throws Exception {
//        // given
//        String userId = "test1";
//        String password = "1234";
//
//        // when
//        mvc.perform(formLogin().user(userId).password(password))
//                .andDo(print())
//                // then
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/"));
//    }
//
//    @Test
//    public void login() throws Exception {
//        //given
//
//        Member activeUser = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        //when
//        log.info("[HomeControllerTest] ActiveUser => {}", activeUser);
//
//        //then
//
//    }
//
//}