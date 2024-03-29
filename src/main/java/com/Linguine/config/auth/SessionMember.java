package com.Linguine.config.auth;

import com.Linguine.domain.member.Member;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionMember implements Serializable {

    private String name;
    private String email;
//    private String name;

    public SessionMember(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
//        this.picture = member.getPicture();

    }
}
