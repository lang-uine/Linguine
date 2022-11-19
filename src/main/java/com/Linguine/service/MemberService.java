package com.Linguine.service;

import com.Linguine.domain.member.Member;
import com.Linguine.domain.member.MemberDTO;
import org.springframework.security.core.userdetails.UserDetails;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MemberService{
    public Long join(Member member);
    public Optional<Member> findByEmail(String email);
    public void validateDuplicateEmail(Member member);
    public void validateDuplicateNickName(Member member);
//    public List<Member> findMembers();
    public Optional<Member> findById(Long memberId);


}
