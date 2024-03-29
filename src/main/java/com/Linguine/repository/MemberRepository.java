package com.Linguine.repository;

import com.Linguine.domain.member.Member;
import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>{

    static final String UPDATE_MEMBER_LAST_LOGIN = "UPDATE Member SET LAST_LOGIN_TIME = :lastLoginTime WHERE EMAIL = :email";

    @Transactional
    @Modifying
    @Query(value = UPDATE_MEMBER_LAST_LOGIN, nativeQuery = true)
    public int updateMemberLastLogin(@Param("email") String email, @Param("lastLoginTime") LocalDateTime lastLoginTime);
    public Optional<Member> findByEmail(@Param("email") String email);
    public List<Member> findAllByNickName(@Param("nickName")String nickName);
    public List<Member> findAllByEmail(@Param("email") String email);

    List<Member> findAll();
    public Optional<Member> findByUserName(@Param("userName") String userName);

    void deleteById(Long id);
}
