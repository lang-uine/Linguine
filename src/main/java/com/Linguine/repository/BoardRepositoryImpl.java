package com.Linguine.repository;

import com.Linguine.domain.board.FreePost;
import com.Linguine.domain.board.Post;
import com.Linguine.domain.board.ReviewPost;
import com.Linguine.domain.board.TradingPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository{

    @PersistenceContext
    private final EntityManager em;

    @Override
    public Long save(Post post) {
        if (post.getId() == null) {
            em.persist(post);
        }else{
            em.merge(post);
        }
        return post.getId();
    }

    @Override
    public Post findOne(Long id) {
        return em.find(Post.class, id);
    }

    @Override
    public List<Post> findAll() {
        return em.createQuery("select i from Post i", Post.class).getResultList();
    }

    @Override
    public List<? extends Post> findByCategory(String category) {
        if (category.equals("free")) {
            return em.createQuery("select i from FreePost i", FreePost.class).getResultList();
        }  else if (category.equals("trade")) {
            return em.createQuery("select i from TradingPost i", TradingPost.class).getResultList();
        } else {
            return em.createQuery("select i from ReviewPost i", ReviewPost.class).getResultList();
        }
    }
}

