package com.Linguine.repository;

import com.Linguine.domain.board.Category;
import com.Linguine.domain.board.Comments;
import com.Linguine.domain.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BoardRepository extends JpaRepository<Post, Long> {

	static final String FIND_HOT_BY_CATEGORY = "SELECT * FROM POST WHERE CATEGORY LIKE :category ORDER BY Hit_Cnt desc Limit 5";
	static final String FIND_ALL_HOT = "SELECT * FROM POST ORDER BY register_time desc Limit 5";
    public List<Post> findByCategory(@Param("category") Category category);
//
//    public List<Comments> findAllCommentsById(Long id);
    @Query(value = FIND_HOT_BY_CATEGORY, nativeQuery = true)
    public List<Post> findHotBoard(@Param("category") Category category);
    @Query(value = FIND_ALL_HOT, nativeQuery = true)
    public List<Post> findHotBoard();
}
