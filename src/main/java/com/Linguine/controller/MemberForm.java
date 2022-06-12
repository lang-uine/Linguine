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
    @NotEmpty(message = "아이디를 입력하세요.")
    private String public_id;
    private String name;
    private String nickName;

    private String password;
    private String password_confirm;
    private String ph;
    private String email;
    private MemberSpec spec;

//    @AssertTrue(message = "비밀번호와 다릅니다.")
//    public boolean confirm(String pw, String pw_confirm) {
//        return pw == pw_confirm;
//    }
}
