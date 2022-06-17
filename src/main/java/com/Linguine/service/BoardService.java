package com.Linguine.service;

import com.Linguine.domain.board.Post;

import java.util.List;


public interface BoardService {
    public Long save(Post post);
    public List<Post> findAllPost();
    public Post findOne(Long postId);
    public List<? extends Post> findByCategory(String category);



}
