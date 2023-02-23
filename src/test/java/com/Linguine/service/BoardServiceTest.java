package com.Linguine.service;

import com.Linguine.domain.board.Comments;
import com.Linguine.domain.board.FreePost;
import com.Linguine.domain.board.Post;
import com.Linguine.domain.member.Member;
import com.Linguine.domain.member.Role;
import com.Linguine.service.BoardService;
import com.Linguine.service.MemberService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
class BoardServiceTest {
    Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    BoardService boardService;
    @Autowired
    MemberService memberService;

    @Test
    @Rollback
    public void BoardRepositoryImplTest() throws Exception {
        Member member = Member.builder()
                .email("123@naver.com")
                .nickName("hello me")
                .name("kim")
                .role(Role.USER)
                .password(new BCryptPasswordEncoder().encode("123"))
                .build();
        Long savedMember = memberService.join(member);
        //given
        FreePost freePost = FreePost.builder()
                .title("hi")
                .contents("hihi hello world")
//            .owner(memberService.findById(savedMember).get().getId())
                .hitCnt(0)
                .commentsCnt(0)
                .build();

        Long savedPost = boardService.save(freePost);

        Comments comments1 = Comments.builder()
                .post(boardService.findById(savedPost).get())
                .member(memberService.findById(savedMember).get())
                .contents("is this hello world?")
                .build();
        Comments comments2 = Comments.builder()
                .post(boardService.findById(savedPost).get())
                .member(memberService.findById(savedMember).get())
                .contents("No?")
                .build();
        Comments comments3 = Comments.builder()
                .post(boardService.findById(savedPost).get())
                .member(memberService.findById(savedMember).get())
                .contents("i think right")
                .build();


        Long savedComment1 = boardService.saveComments(comments1);
        Long savedComment2 = boardService.saveComments(comments2);
        Long savedComment3 = boardService.saveComments(comments3);


        //when
        List<Comments> res = boardService.findAllCommentsById(savedPost);

        //then
        log.info("res = " + res);
        log.info(boardService.findById(savedPost).get().getContents());

    }

}