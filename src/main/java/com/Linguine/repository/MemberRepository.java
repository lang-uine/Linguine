package com.Linguine.repository;

import com.Linguine.domain.member.Member;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MemberRepository {
    public void save(Member member);
    public Member findOne(Long id);
    public List<Member> findAll();
    public List<Member> findByName(String name);
//    public int updateMemberLastLogin(String email, LocalDateTime localDateTime);
    public int updateMemberLastLogin(@Param("email") String email, @Param("lastLoginTime") LocalDateTime lastLoginTime);

}
