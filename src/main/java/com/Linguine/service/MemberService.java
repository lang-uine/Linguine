package com.Linguine.service;

import com.Linguine.domain.member.Member;

import java.util.Optional;

public interface MemberService{
    public Long join(Member member);
    public Member findByEmail(String email);
    public void validateDuplicateEmail(Member member);
    public void validateDuplicateNickName(Member member);
//    public List<Member> findMembers();
    public Optional<Member> findById(Long memberId);
//    public UserDetails loadUserByUsername(String email);


}
