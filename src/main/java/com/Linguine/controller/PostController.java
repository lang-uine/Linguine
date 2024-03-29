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

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final BoardService boardService;
    private final MemberService memberService;

    @RequestMapping(value = "/boards/{category}/{id}", method = RequestMethod.GET)
    public String post(@PathVariable("id") Long id, @PathVariable("category") String category, @AuthenticationPrincipal MemberAdapter memberAdapter, Model model) {
        Optional<Post> post = boardService.findById(id);
        model.addAttribute("post", post.get());
        model.addAttribute("writer", memberService.findById(post.get().getOwner()).get().getName());
        model.addAttribute("comments", boardService.findAllCommentsById(id));
        model.addAttribute("activeUser", memberAdapter.getMember());
        model.addAttribute("form", new CommentForm());
        return "boards/post";
    }

    @PostMapping(value = "/boards/{category}/{id}")
    public String saveComment(@PathVariable("id") Long id, @PathVariable("category") String category, @Valid CommentForm form, Model model,  @AuthenticationPrincipal MemberAdapter memberAdapter) {
        Optional<Post> post = boardService.findById(id);
        Comments comments = Comments.builder()
                .post(post.get())
                .member(memberService.findById(memberAdapter.getMember().getId()).get())
                .contents(form.getContent())
                .comment_password(form.getPassword())
                .build();
        log.info("[PostController] New comment posted -> {}", form.getContent());
        boardService.saveComments(comments);

        return "redirect:"+id;
    }

    @RequestMapping(value = "/boards/{category}/{post_id}/delete")
    public String deleteComment(@RequestParam("id") Long id, @PathVariable("post_id") Long post_id, @PathVariable("category") String category) {
        Optional<Comments> comments = boardService.findCommentById(id);
        boardService.deleteComments(comments.get());
        log.info("[PostController] Comment id {} has been deleted.", id);

        return "redirect:";

    }
}
