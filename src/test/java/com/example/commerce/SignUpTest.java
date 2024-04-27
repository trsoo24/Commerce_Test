package com.example.commerce;

import com.example.commerce.entity.dao.UserDao;
import com.example.commerce.entity.dto.SignUpDto;
import com.example.commerce.repository.UserRepository;
import com.example.commerce.service.CheckUserReference;
import com.example.commerce.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SignUpTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private CheckUserReference checkUserReference;

    @Test
    @DisplayName("회원가입 성공")
    void successSignUp() {
        //given
        SignUpDto signUpDto = SignUpDto.builder()
                .userId("testId")
                .password("password")
                .nickname("nickname")
                .name("이름")
                .phoneNumber("010-1111-1234")
                .email("test@naver.com")
                .build();

        //when
        UserDao signUpDao = userService.signUp(signUpDto);

        //then
        assertNotNull(signUpDao);

        assertEquals("testId", signUpDao.getUserId());
        assertEquals("nickname", signUpDao.getNickname());
        assertEquals("이름", signUpDao.getName());
        assertEquals("010-1111-1234", signUpDao.getPhoneNumber());
        assertEquals("test@naver.com", signUpDao.getEmail());
    }
}
