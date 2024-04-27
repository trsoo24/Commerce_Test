package com.example.commerce.service;

import com.example.commerce.entity.User;
import com.example.commerce.exception.CustomException;
import com.example.commerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.commerce.exception.CustomCode.*;

@Service
@RequiredArgsConstructor
public class CheckUserReference {
    private final UserRepository userRepository;

    public void existUserId(String userId) {
        if (userRepository.existsByUserId(userId)) {
            throw new CustomException(DUPLICATED_USERID);
        }
    }

    public void existNickname(String nickName) {
        if (userRepository.existsByNickname(nickName)) {
            throw new CustomException(DUPLICATED_NICKNAME);
        }
    }

    public void existPhoneNumber(String phoneNumber) {
        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new CustomException(DUPLICATED_PHONE_NUMBER);
        }
    }

    public void existEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new CustomException(DUPLICATED_EMAIL);
        }
    }

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new CustomException(USER_NOT_FOUND));
    }
}
