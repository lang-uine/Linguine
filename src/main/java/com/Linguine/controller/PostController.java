package com.Linguine.controller;

import com.Linguine.domain.board.Comments;
import com.Linguine.domain.board.Post;
import com.Linguine.domain.member.MemberAdapter;
import com.Linguine.service.BoardService;
import com.Linguine.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attoparser.dom.Comment;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final BoardService boardService;
    private final MemberService memberService;
//    private final Logger logger;

    @RequestMapping(value = "/boards/free/post", method = RequestMethod.GET)
    public String getPost(@RequestParam("id") Long id, @AuthenticationPrincipal MemberAdapter memberAdapter, Model model){
        Post post = boardService.findOne(id);
        model.addAttribute("post", post);
        model.addAttribute("writer", post.getWriter().getName());
        model.addAttribute("comments", boardService.findAllCommentsById(id));
        model.addAttribute("newCommentsForm", new CommentForm());
        model.addAttribute("activeUserName", memberAdapter.getMember().getName());
        System.out.println("getPostid = " + id);
        return "boards/post";
    }

    @PostMapping(value = "/boards/free/post")
    public String commentPost(@RequestParam("id") Long id, CommentForm commentForm) {
        log.info("comment => {}", commentForm.getContent());
        Post foundOne = boardService.findOne(id);
        boardService.saveComments(Comments
                .builder()
                .member(foundOne.getWriter())
                .post(foundOne)
                .contents(commentForm.getContent())
                .build());
        return "redirect:/";
    }


}
