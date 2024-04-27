package com.example.commerce;

import com.example.commerce.entity.dto.SignUpDto;
import com.example.commerce.exception.CustomException;
import com.example.commerce.repository.UserRepository;
import com.example.commerce.service.CheckUserReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CheckUserReferenceTests {
    @InjectMocks
    private CheckUserReference checkUserReference;
    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("회원가입 실패 - 유저 아이디 중복")
    void failSignUpCauseUserId() {
        //given
        SignUpDto signUpDto = SignUpDto.builder()
                .userId("testId")
                .password("password")
                .nickname("nickname")
                .name("이름")
                .phoneNumber("010-1111-1234")
                .email("test@naver.com")
                .build();

        // when
        when(userRepository.existsByUserId(signUpDto.getUserId())).thenReturn(true);
        // then
        assertThrows(CustomException.class, () -> checkUserReference.existUserId(signUpDto.getUserId()));
    }

    @Test
    @DisplayName("회원가입 실패 - 닉네임 중복")
    void failSignUpCauseNickname() {
        //given
        SignUpDto signUpDto = SignUpDto.builder()
                .userId("testId")
                .password("password")
                .nickname("nickname")
                .name("이름")
                .phoneNumber("010-1111-1234")
                .email("test@naver.com")
                .build();

        // when
        when(userRepository.existsByNickname(signUpDto.getNickname())).thenReturn(true);
        // then
        assertThrows(CustomException.class, () -> checkUserReference.existNickname(signUpDto.getNickname()));
    }

    @Test
    @DisplayName("회원가입 실패 - 전화번호 중복")
    void failSignUpCausePhoneNumber() {
        //given
        SignUpDto signUpDto = SignUpDto.builder()
                .userId("testId")
                .password("password")
                .nickname("nickname")
                .name("이름")
                .phoneNumber("010-1111-1234")
                .email("test@naver.com")
                .build();

        // when
        when(userRepository.existsByPhoneNumber(signUpDto.getPhoneNumber())).thenReturn(true);
        // then
        assertThrows(CustomException.class, () -> checkUserReference.existPhoneNumber(signUpDto.getPhoneNumber()));
    }

    @Test
    @DisplayName("회원가입 실패 - 이메일 중복")
    void failSignUpCauseEmail() {
        //given
        SignUpDto signUpDto = SignUpDto.builder()
                .userId("testId")
                .password("password")
                .nickname("nickname")
                .name("이름")
                .phoneNumber("010-1111-1234")
                .email("test@naver.com")
                .build();

        // when
        when(userRepository.existsByEmail(signUpDto.getEmail())).thenReturn(true);
        // then
        assertThrows(CustomException.class, () -> checkUserReference.existEmail(signUpDto.getEmail()));
    }
}
