package com.Linguine.repository;

import com.Linguine.domain.board.Category;
import com.Linguine.domain.board.Comments;
import com.Linguine.domain.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BoardRepository extends JpaRepository<Post, Long> {


    public List<Post> findByCategory(Category category);
//
//    public List<Comments> findAllCommentsById(Long id);
}
