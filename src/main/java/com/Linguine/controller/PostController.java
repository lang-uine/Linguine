package com.Linguine.controller;

import com.Linguine.domain.board.Post;
import com.Linguine.domain.member.MemberAdapter;
import com.Linguine.service.BoardService;
import com.Linguine.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final BoardService boardService;
    private final MemberService memberService;
//    private final Logger logger;

    @RequestMapping(value = "/boards/free/post", method = RequestMethod.GET)
    public String post(@RequestParam("id") Long id, @AuthenticationPrincipal MemberAdapter memberAdapter, Model model){
        Post post = boardService.findOne(id);
        model.addAttribute("post", post);
        model.addAttribute("writer", memberService.findById(post.getOwner()).get().getName());
        model.addAttribute("comments", boardService.findAllCommentsById(id));
        model.addAttribute("activeUserName", memberAdapter.getMember().getName());

        return "boards/post";
    }

//    @RequestMapping(value = "/boards/free/post", method = RequestMethod.POST)
//    public String commentPost(@RequestParam("id") Long id, Model model) {
//        Post post = boardService.findOne(id);
//
//    }


}
