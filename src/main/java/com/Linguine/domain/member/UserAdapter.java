package com.Linguine.domain.member;

import lombok.Getter;

import java.io.Serializable;
import java.util.Map;

@Getter
public class UserAdapter extends CustomUserDetails {

    private Member member;
    private Map<String, Object> attributes;

    public UserAdapter(Member member){
        super(member);
        this.member = member;
    }


    public UserAdapter(Member member, Map<String, Object> attributes){
        super(member, attributes);
        this.member = member;
        this.attributes = attributes;
    }
}