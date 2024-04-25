package com.example.commerce.service;

import com.example.commerce.exception.CustomException;
import com.example.commerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static com.example.commerce.exception.CustomCode.*;

@Service
@RequiredArgsConstructor
public class CheckUserReference {
    private final UserRepository userRepository;

    void existUserId(String userId) {
        if (userRepository.existsByUserId(userId)) {
            throw new CustomException(DUPLICATED_USERID);
        }
    }

    void existNickname(String nickName) {
        if (userRepository.existsByNickname(nickName)) {
            throw new CustomException(DUPLICATED_NICKNAME);
        }
    }

    void existPhoneNumber(String phoneNumber) {
        checkPhoneNumberForm(phoneNumber);
        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new CustomException(DUPLICATED_PHONE_NUMBER);
        }
    }

    void checkEmail(String email) {
        checkEmailForm(email);
        if (userRepository.existsByEmail(email)) {
            throw new CustomException(DUPLICATED_EMAIL);
        }
    }

    void checkPhoneNumberForm(String phoneNumber) { // 전화번호 양식 확인 010-1234-1234
        String pattern = "^\\d{3}-\\d{4}-\\d{4}$";
        if (!Pattern.matches(pattern, phoneNumber)) {
            throw new CustomException(NEED_MODIFY_PHONE_NUMBER_FORM);
        }
    }

    void checkEmailForm(String email) { // 이메일 양식 확인 email@email.com
        String pattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
        if (!Pattern.matches(pattern, email)) {
            throw new CustomException(NEED_MODIFY_EMAIL_FORM);
        }
    }
}
