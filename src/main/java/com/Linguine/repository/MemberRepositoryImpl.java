package com.Linguine.repository;

import com.Linguine.domain.member.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MemberRepositoryImpl implements MemberRepository{

//    static final String UPDATE_MEMBER_LAST_LOGIN = "UPDATE Member SET LAST_LOGIN_TIME = :lastLoginTime WHERE public_id = :public_id";
    @PersistenceContext
    private EntityManager em;//EntityManager를 만들어서 주입해줌

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    @Override
    public List<Member> findByName(String public_id) {
        return em.createQuery("select m from Member m where m.public_Id = :public_id", Member.class)
                .setParameter("public_id", public_id)
                .getResultList();
    }
    static final String UPDATE_MEMBER_LAST_LOGIN = "UPDATE Member "
            + "SET LAST_LOGIN_TIME = :lastLoginTime "
            + "WHERE EMAIL = :email";

    @Transactional
    @Modifying
    @Query(value=UPDATE_MEMBER_LAST_LOGIN, nativeQuery = true)
    public int updateMemberLastLogin(@Param("email") String email, @Param("lastLoginTime") LocalDateTime lastLoginTime);
    public Member findByEmail(String emfail);

//    @Override
//    @Transactional
//    @Modifying
//    @Query(value = UPDATE_MEMBER_LAST_LOGIN, nativeQuery = true)
//    public int updateMemberLastLogin(@Param("public_id") String public_id, @Param("lastLoginTime") LocalDateTime localDateTime) {
//
//    }
}
