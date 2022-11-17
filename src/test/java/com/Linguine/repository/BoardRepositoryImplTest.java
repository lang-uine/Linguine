package com.Linguine.repository;

import com.Linguine.domain.board.Comments;
import com.Linguine.domain.board.FreePost;
import com.Linguine.domain.member.Member;
import com.Linguine.service.BoardService;
import com.Linguine.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
class BoardRepositoryImplTest {
    @Autowired
    BoardService boardService;
    @Autowired
    MemberService memberService;

@Test
@Rollback(value = false)
public void BoardRepositoryImplTest() throws Exception {
    Member member = Member.builder()
            .email("123@naver.com")
            .nickName("hello me")
            .name("kim")
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
            .post(boardService.findOne(savedPost))
            .member(memberService.findById(savedMember).get())
            .contents("is this hello world?")
            .build();
    Comments comments2 = Comments.builder()
            .post(boardService.findOne(savedPost))
            .member(memberService.findById(savedMember).get())
            .contents("No?")
            .build();
    Comments comments3 = Comments.builder()
            .post(boardService.findOne(savedPost))
            .member(memberService.findById(savedMember).get())
            .contents("i think right")
            .build();


    Long savedComment1 = boardService.saveComments(comments1);
    Long savedComment2 = boardService.saveComments(comments2);
    Long savedComment3 = boardService.saveComments(comments3);


    //when
    List<Comments> res = boardService.findAllCommentsById(savedPost);

    //then
    System.out.println("res = " + res);
    System.out.println(boardService.findOne(savedPost).getCommentsCnt());

}

}