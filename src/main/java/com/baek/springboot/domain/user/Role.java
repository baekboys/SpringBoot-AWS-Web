package com.baek.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반사용자");

    private final String key;
    private final String title;
}
