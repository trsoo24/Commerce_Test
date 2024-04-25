package com.example.commerce;

import com.example.commerce.entity.User;
import com.example.commerce.entity.dao.SignUpDao;
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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
@AutoConfigureMockMvc
public class SignUpTests {
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

        User user = User.builder()
                .id(1L)
                .userId("testId")
                .password("password")
                .nickname("nickname")
                .name("이름")
                .phoneNumber("010-1111-1234")
                .email("test@naver.com")
                .build();
        //when
        when(userRepository.save(any(User.class))).thenReturn(user);
        SignUpDao signUpDao = userService.signUp(signUpDto);

        //then
        assertNotNull(signUpDao);

        assertEquals("testId", signUpDao.getUserId());
        assertEquals("nickname", signUpDao.getNickname());
        assertEquals("이름", signUpDao.getName());
        assertEquals("010-1111-1234", signUpDao.getPhoneNumber());
        assertEquals("test@naver.com", signUpDao.getEmail());
    }
}
