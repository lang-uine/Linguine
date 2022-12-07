package com.Linguine.controller;

import com.Linguine.domain.board.Category;
import com.Linguine.domain.member.MemberAdapter;
import com.Linguine.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardManagementController {
    private final BoardService boardService;

    @GetMapping("management/board")
    public String getPostList(Model model, @AuthenticationPrincipal MemberAdapter memberAdapter, @RequestParam(value = "category", required = false) Optional<String> category) {
        model.addAttribute("categories", Category.values());
        model.addAttribute("activeUser", memberAdapter);
        if (category.isEmpty()) {
            model.addAttribute("postList", boardService.findAllPost());
        } else {
            model.addAttribute("postList", boardService.findByCategory(Category.valueOf(category.get())));
        }
        return "management/boardManagement";
    }

    @RequestMapping("management/board/delete")
    public String deletePost(@RequestParam(value = "id") Long id) {
        Long deleted = boardService.deletePost(id);
        log.info("[BoardManagementController] Post id = {} Deleted.", id);
        return "redirect:/management/board/";
    }
}
