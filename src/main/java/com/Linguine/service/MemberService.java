package com.Linguine.service;

import com.Linguine.domain.member.Member;

import java.util.List;

public interface MemberService {
    public Long join(Member member);
//    public void validateDuplicateMember(Member member);
    public List<Member> findMembers();
    public Member findOne(Long memberId);

}
