package com.Linguine.service;

import com.Linguine.domain.board.Post;
import com.Linguine.domain.board.TradingPost;
import com.Linguine.domain.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Autowired
    MemberService memberService;

    @Test
    @Transactional
    @Rollback(value = false)
    public void SaveTest() throws Exception {
        //given
        TradingPost tradingPost = new TradingPost();
        tradingPost.setTitle("trade for something");
        //when
        boardService.save(tradingPost);
        Long saveid = tradingPost.getId();
        //then
    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void joinTest() throws Exception {
        //given
        Member member = new Member();
        member.setPublic_Id("kim");
        //when
        memberService.join(member);


        //then

    }


}