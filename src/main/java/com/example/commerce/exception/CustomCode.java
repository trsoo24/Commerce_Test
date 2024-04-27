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
    NEED_MODIFY_EMAIL_FORM(HttpStatus.BAD_REQUEST, "올바르지 않은 이메일 양식입니다. user@email.com"),

    // 유저 조회 실패
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "찾을 수 없는 유저입니다."),
    NEGATIVE_PAGE_VALUE(HttpStatus.BAD_REQUEST, "요청하신 페이지가 음수 값입니다."),
    NEGATIVE_PAGE_SIZE_VALUE(HttpStatus.BAD_REQUEST, "요청하신 전체 페이지가 음수 값입니다."),
    SORT_ERROR(HttpStatus.BAD_REQUEST, "가입일 혹은 이름 순으로만 정렬 가능합니다.")
    ;

    private final HttpStatus status;
    private final String message;
}
