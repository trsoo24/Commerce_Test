package com.example.commerce.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CustomCode {

    // 회원가입 성공
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료되었습니다."),

    // 회원가입 유효성 검사
    DUPLICATED_USERID(HttpStatus.BAD_REQUEST, "이미 가입된 아이디입니다."),
    DUPLICATED_NICKNAME(HttpStatus.BAD_REQUEST, "중복된 닉네임입니다."),
    DUPLICATED_PHONE_NUMBER(HttpStatus.BAD_REQUEST, "이미 가입된 휴대폰 번호입니다."),
    DUPLICATED_EMAIL(HttpStatus.BAD_REQUEST, "이미 가입된 이메일입니다."),
    NEED_MODIFY_PHONE_NUMBER_FORM(HttpStatus.BAD_REQUEST, "올바르지 않은 전화번호 양식입니다. 010-1234-1234"),
    NEED_MODIFY_EMAIL_FORM(HttpStatus.BAD_REQUEST, "올바르지 않은 이메일 양식입니다. user@email.com")
    ;

    private final HttpStatus status;
    private final String message;
}
