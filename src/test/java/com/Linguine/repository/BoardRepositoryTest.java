package com.Linguine.repository;

import com.Linguine.domain.board.Post;
import com.Linguine.domain.board.ReviewPost;
import com.Linguine.domain.board.TradingPost;
import com.Linguine.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardService boardService;

    @Test
    public void BoardRepositoryTest() throws Exception {
        //given
        Post post = new Post();
        post.setPost_Owner("commonpost_save");
        TradingPost tp = new TradingPost();
        tp.setPost_Title("trpost_save");

        //when
        boardService.savePost(post);
        boardService.savePost(tp);

        //then

    }

}