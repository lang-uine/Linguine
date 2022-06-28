package com.Linguine.controller;


import com.Linguine.domain.board.FreePost;
import com.Linguine.domain.board.Post;
import com.Linguine.domain.board.ReviewPost;
import com.Linguine.domain.board.TradingPost;
import com.Linguine.domain.member.MemberDTO;
import com.Linguine.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    //        @GetMapping("/boards/")//게시글 등록을 누르면 현재 url의 category를 따와서 어디에 글을 쓸건지 생각
//        public String newFreepost(Model model, @RequestParam("category") String category ) {
//            System.out.println("category = " + category);
//            model.addAttribute("newPostForm", new PostForm());
//            return "/boards/newPost";
//    }
    @RequestMapping(value = "/boards/write", method = RequestMethod.GET)
    public String post(Model model, @RequestParam("category") String category) {
        model.addAttribute("category", category);
        model.addAttribute("newPostForm", new PostForm());
        return "boards/postForm";
    }


    @RequestMapping(value = "/boards", method = RequestMethod.GET)
    public String boardSelection(@RequestParam("category") String category, @AuthenticationPrincipal MemberDTO memberDTO, Model model) {
        if (memberDTO == null) {
            model.addAttribute("activeUserName", "게스트");
        } else {
            model.addAttribute("activeUserName", memberDTO.getMember().getNickName());
        }
        model.addAttribute("posts", boardService.findByCategory(category));
        model.addAttribute("category", category);
        return "boards/" + category + "board";
    }

    @PostMapping(value =  "boards/write")
    public String post(@Valid PostForm form, BindingResult result, @RequestParam("category") String category) {
        Post post = null;

        if (category.equals("free")) {
            System.out.println("post = " + post);
            post = new FreePost();
        } else if (category.equals("trade")) {
            post = new TradingPost();
            System.out.println("post = " + post);
        } else {
            post = new ReviewPost();
            System.out.println("post = " + post);
        }

        post.setTitle(form.getTitle());
        post.setContents(form.getContent());
        boardService.save(post);
        return "redirect:/boards?category="+category;
    }
//    @PostMapping("boards/tradeboard/newPost")
//    public String tradepost(@Valid PostForm form, BindingResult result) {
//        TradingPost post = new TradingPost();
//        post.setTitle(form.getTitle());
//        post.setContents(form.getContent());
//        boardService.save(post);
//        return "redirect:/boards/tradeboard";
//    }
//    @PostMapping("boards/reviewboard/newPost")
//    public String reviewpost(@Valid PostForm form, BindingResult result) {
//        ReviewPost post = new ReviewPost();
//        post.setTitle(form.getTitle());
//        post.setContents(form.getContent());
//        boardService.save(post);
//        return "redirect:/boards/reviewboard";
//    }


}
