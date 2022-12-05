package com.Linguine.service;

import com.Linguine.domain.board.Category;
import com.Linguine.domain.board.Comments;
import com.Linguine.domain.board.Post;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface BoardService {
    public Long save(Post post);
    public Long saveComments(Comments comments);

    public Optional<Post> findById(Long id);
    public List<Post> findAllPost();
    public List<? extends Post> findByCategory(Category category);
    public List<Comments> findAllCommentsById(Long id);



}
