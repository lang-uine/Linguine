package com.Linguine.service;

import com.Linguine.domain.board.Category;
import com.Linguine.domain.board.Comments;
import com.Linguine.domain.board.Post;
import com.Linguine.repository.BoardRepository;
import com.Linguine.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
@Slf4j
public class BoardServiceImpl implements BoardService{
    //2022-05-08-yeoooo 1개의 생성자는 Autowired 없이 바로 의존성 주입
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public Long save(Post post) {
        boardRepository.save(post);
        return post.getId();
    }

    @Override
    @Transactional
    public Long saveComments(Comments comments) {
        commentRepository.save(comments);
        comments.getPost().addCountComment();
        return comments.getId();
    }

    @Override
    @Transactional
    public Long deletePost(Long id) {
//        Optional<Post> found = boardRepository.findById(id);
        boardRepository.deleteById(id);
        return id;
    }
    @Override
    public List<Post> findAllPost() {
        return boardRepository.findAll();
    }


    public Optional<Post> findById(Long postId) {
        return boardRepository.findById(postId);
    }

    @Override
    public List<Post> findByCategory(Category category) {
        return boardRepository.findByCategory(category);
    }

    @Override
    public List<Comments> findAllCommentsById(Long id) {
        return commentRepository.findAllCommentsByPost(id);
    }
}
