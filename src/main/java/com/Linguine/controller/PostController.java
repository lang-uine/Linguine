package com.Linguine.controller;

import com.Linguine.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final BoardService boardService;
//    private final Logger logger;

    @RequestMapping(value = "/boards/free/post", method = RequestMethod.GET)
    public String post(@RequestParam("id") Long id,Model model){
        model.addAttribute("post", boardService.findOne(id));
        return "boards/post";
    }
}
