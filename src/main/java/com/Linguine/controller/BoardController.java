package com.Linguine.controller;

import com.Linguine.domain.board.*;
import com.Linguine.domain.member.MemberAdapter;
import com.Linguine.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final BoardService boardService;


    @RequestMapping(value = "/boards/{category}/write", method = RequestMethod.GET)
    public String getPostForm(Model model, @PathVariable("category") String category) {
        model.addAttribute("category", category);
        model.addAttribute("newPostForm", new PostForm());
        return "boards/postForm";
    }

    @RequestMapping(value = "/boards/{category}", method = RequestMethod.GET)
    public String boardSelection(@PathVariable(value = "category") String category, @AuthenticationPrincipal MemberAdapter memberAdapter, Model model) {
        if (memberAdapter == null) {
            model.addAttribute("activeUser", null);
        } else {
            model.addAttribute("activeUser", memberAdapter.getMember());
        }
        model.addAttribute("posts", boardService.findByCategory(Category.valueOf(category)));
        model.addAttribute("category", category);
        log.info("[BoardController] {} board selected.", category);
        return "boards/" + category.toLowerCase()+"board";
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

        return "redirect:/boards/"+category;
    }


}
