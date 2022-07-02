package com.Linguine.service;

import com.Linguine.domain.member.Member;
import com.Linguine.domain.member.MemberDTO;
import com.Linguine.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService,UserDetailsService{

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
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public void validateDuplicateEmail(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findAllByEmail(member.getEmail());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 이메일입니다");
        }
    }

    @Override
    public void validateDuplicateNickName(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findAllByNickName(member.getNickName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 닉네임입니다");
        }
    }



//    @Override
//    public List<Member> findMembers() {
//        return memberRepository.findAll();
//    }
//


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);
        if(member == null){ throw new UsernameNotFoundException("Not Found account");}
        return new MemberDTO(member);
    }
}
