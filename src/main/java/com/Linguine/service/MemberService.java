package com.Linguine.service;

import com.Linguine.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
public interface MemberService{
    public Long join(Member member);
    public Member findByEmail(String email);
    public void validateDuplicateEmail(Member member);
    public void validateDuplicateNickName(Member member);
//    public List<Member> findMembers();
//    public Member findOne(Long memberId);
//    public UserDetails loadUserByUsername(String email);


}
