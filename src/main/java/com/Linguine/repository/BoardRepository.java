package com.Linguine.repository;

import com.Linguine.domain.board.FreePost;
import com.Linguine.domain.board.Post;

import java.util.List;


public interface BoardRepository {
    public Long save(Post post);
    public Post findOne(Long id);
    public List<Post> findAll();
    public List<? extends Post> findByCategory(String category);
}
