package com.Linguine.service;

import com.Linguine.domain.member.Member;
import com.Linguine.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements UserDetailsService,MemberService {

    private final MemberRepository memberRepository;

//    회원가입
    @Transactional
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    //    @Override
//    public void validateDuplicateMember(Member member) {
//        //EXCEPTION
//        List<Member> findMembers = memberRepository.findByName(member.getName());
//        if (!findMembers.isEmpty()) {
//            throw new IllegalStateException("이미 존재하는 회원입니다");
//        }
//    }

//    @Override
//    public List<Member> findMembers() {
//        return memberRepository.findAll();
//    }
//
//    @Override
//    public Member findOne(Long memberId) {
//        return memberRepository.findOne(memberId);
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);
        if(member == null){ throw new UsernameNotFoundException("Not Found account");}
        return member;
    }
}
