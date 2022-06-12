package com.Linguine.repository;

import com.Linguine.domain.member.Member;

import java.util.List;

public interface MemberRepository {
    public void save(Member member);
    public Member findOne(Long id);
    public List<Member> findAll();
    public List<Member> findByName(String name);


}
