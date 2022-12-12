package com.Linguine.controller;

import com.Linguine.domain.board.Comments;
import com.Linguine.domain.board.Post;
import com.Linguine.domain.member.MemberAdapter;
import com.Linguine.service.BoardService;
import com.Linguine.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final BoardService boardService;
    private final MemberService memberService;
//    private final Logger logger;
    @RequestMapping(value = "/boards/{category}/post", method = RequestMethod.GET)
    public String post(@RequestParam("id") Long id, @PathVariable("category") String category, @AuthenticationPrincipal MemberAdapter memberAdapter, Model model){
        Optional<Post> post = boardService.findById(id);
        model.addAttribute("post", post.get());
        model.addAttribute("writer", memberService.findById(post.get().getOwner()).get().getName());
        model.addAttribute("comments", boardService.findAllCommentsById(id));
        model.addAttribute("activeUser", memberAdapter.getMember());
        model.addAttribute("form", new CommentForm());

        return "boards/post";
    }

    @PostMapping(value = "/boards/{category}/post")
    public String commentPost(@RequestParam("id") Long id, @PathVariable("category") String category, @Valid CommentForm form, Model model) {
        Optional<Post> post = boardService.findById(id);
        Comments comments = Comments.builder()
                .post(post.get())
                .member(memberService.findById(post.get().getOwner()).get())
                .contents(form.getContent())
                .comment_password(form.getPassword())
                .build();
        log.info("new comment => {}",form.getContent());
        boardService.saveComments(comments);

        return "redirect:post?id=" + post.get().getId();
    }


}
