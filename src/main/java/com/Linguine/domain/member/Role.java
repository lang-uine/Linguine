package com.Linguine.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "유저"),
    MANAGER("ROLE_MANAGER", "관리자");

    private final String key;
    private final String title;

}
