package com.Linguine.repository;

import com.Linguine.domain.board.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments, Long> {
    @Query("select i from Comments i where i.post.id = :postId")
    List<Comments> findAllCommentsByPost(@Param("postId") Long postId);

}
