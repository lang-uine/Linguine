package com.Linguine.controller;


import com.Linguine.domain.board.FreePost;
import com.Linguine.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boards/free")
    public String board(Model model) {
        model.addAttribute("posts", boardService.findAllPost());
        return "/boards/freeboard";
    }

    @GetMapping("/boards/newPost")
    public String newPostForm(Model model) {
        model.addAttribute("newPostForm", new PostForm());
        return "/boards/newPost";
    }

    @PostMapping("boards/newPost")
    public String post(@Valid PostForm form, BindingResult result) {
        FreePost freePost = new FreePost();
        freePost.setTitle(form.getTitle());
        freePost.setContents(form.getContent());
        boardService.save(freePost);
        return "redirect:/boards/free";
    }
}
