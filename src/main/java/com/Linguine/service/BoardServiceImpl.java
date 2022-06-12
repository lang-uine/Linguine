package com.Linguine.service;

import com.Linguine.domain.board.Post;
import com.Linguine.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService{
    //2022-05-08-yeoooo 1개의 생성자는 Autowired 없이 바로 의존성 주입
    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public Long save(Post post) {
        boardRepository.save(post);
        return post.getId();
    }

    @Override
    public List<Post> findAllPost() {
        return boardRepository.findAll();
    }

    @Override
    public Post findOne(Long postId) {
        return boardRepository.findOne(postId);
    }

}
