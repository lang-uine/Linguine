package com.Linguine.controller;

import com.Linguine.domain.board.Category;
import com.Linguine.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.DiscriminatorValue;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardManagementController {
    private final BoardService boardService;
    @GetMapping("management/board")
    public String getPostList(Model model, @RequestParam(value = "category", required = false) Optional<String> category) {
        model.addAttribute("categories", Category.values());
        if (category.isEmpty()) {
            model.addAttribute("postList",boardService.findAllPost());
        } else {
            model.addAttribute("postList", boardService.findByCategory(Category.valueOf(category.get())));
        }

        return "management/boardManagement";
    }
}
