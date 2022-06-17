package com.Linguine.service;

import com.Linguine.domain.member.Member;
import com.Linguine.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{


    private final MemberRepository memberRepository;

    //회원가입
    @Transactional
    @Override
    public Long join(Member member) {
//        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

//    @Override
//    public void validateDuplicateMember(Member member) {
//        //EXCEPTION
//        List<Member> findMembers = memberRepository.findByName(member.getName());
//        if (!findMembers.isEmpty()) {
//            throw new IllegalStateException("이미 존재하는 회원입니다");
//        }
//    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
