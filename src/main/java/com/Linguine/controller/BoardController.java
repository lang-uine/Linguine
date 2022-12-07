package com.Linguine.controller;


import com.Linguine.config.auth.SessionMember;
import com.Linguine.domain.board.*;
import com.Linguine.domain.member.MemberAdapter;
import com.Linguine.domain.member.MemberDTO;
import com.Linguine.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public String boardSelection(@RequestParam(value = "category", required = false) String category, @AuthenticationPrincipal MemberAdapter memberAdapter, Model model) {
        if (memberAdapter == null) {
            model.addAttribute("activeUserName", "게스트");
        } else {
            model.addAttribute("activeUserName", memberAdapter.getMember().getName());
        }
        model.addAttribute("posts", boardService.findByCategory(Category.valueOf(category)));
        model.addAttribute("category", category);
        return "boards/" + category + "board";
    }

    @PostMapping(value = "boards/write")
    public String post(@Valid PostForm form, BindingResult result, @RequestParam("category") String category, @AuthenticationPrincipal MemberAdapter memberAdapter) {

        if (category.equals("Free")) {
            FreePost post = FreePost.builder()
                    .title(form.getTitle())
                    .category(Category.Free)
                    .contents(form.getContent())
                    .owner(memberAdapter.getMember().getId())
                    .commentsCnt(0)
                    .hitCnt(0)
                    .build();
            boardService.save(post);

        } else if (category.equals("Trade")) {

            TradingPost post = TradingPost.builder()
                    .title(form.getTitle())
                    .category(Category.Trade)
                    .contents(form.getContent())
                    .owner(memberAdapter.getMember().getId())
                    .commentsCnt(0)
                    .hitCnt(0)
                    //2022-07-1_yeoooo : 구매/판매 여부, 만기 여부, 가격
//                    .isBuying(form.get)
//                    .isExpired()
//                    .price()
                    .build();
            boardService.save(post);
        } else {
            ReviewPost post = ReviewPost.builder()
                    .title(form.getTitle())
                    .category(Category.Review)
                    .contents(form.getContent())
                    .owner(memberAdapter.getMember().getId())
                    .commentsCnt(0)
                    .hitCnt(0)
                    .build();
            boardService.save(post);
        }

        return "redirect:/boards?category=" + category;
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
