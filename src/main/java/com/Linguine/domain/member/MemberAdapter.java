package com.Linguine.domain.member;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public class MemberAdapter extends CustomUserDetails {

    private Member member;
    private Map<String, Object> attributes;

    public MemberAdapter(Member member){
        super(member);
        this.member = member;
    }

    public MemberAdapter(Member member, Map<String, Object> attributes){
        super(member, attributes);
        this.member = member;
        this.attributes = attributes;
    }
}