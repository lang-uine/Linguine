package com.Linguine.controller;

import com.Linguine.domain.member.MemberSpec;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

@Getter
@ToString
@Setter
public class MemberForm {

    @NotEmpty(message = "이름를 입력하세요.")
    private String name;
    @NotEmpty(message = "닉네임을 입력하세요.")
    private String nickName;

    @NotEmpty(message = "패스워드를 입력하세요.")
    private String password;
    private String password_confirm;

    @NotEmpty(message = "이메일을 입력하세요.")
    private String email;
    private MemberSpec spec;


}
