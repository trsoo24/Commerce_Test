package com.example.commerce;

import com.example.commerce.entity.User;
import com.example.commerce.entity.dao.UserDao;
import com.example.commerce.entity.dto.ModifyUserDto;
import com.example.commerce.repository.UserRepository;
import com.example.commerce.service.CheckUserReference;
import com.example.commerce.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModifyUserTests {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private CheckUserReference checkUserReference;

    @Test
    @DisplayName("회원 정보 수정 - 성공")
    void modifyUserSuccess() {
        //given
        User user = User.builder()
                .id(1L)
                .userId("testUser")
                .password("1234")
                .nickname("닉네임")
                .name("이름")
                .phoneNumber("010-1234-1234")
                .email("test@email.com")
                .registeredAt(LocalDateTime.now())
                .build();

        //when
        ModifyUserDto modifyUserDto = ModifyUserDto.builder()
                .password("변경된 비밀번호")
                .nickname("변경된 닉네임")
                .phoneNumber("010-4321-4321")
                .email("changed@email.com")
                .build();

        when(checkUserReference.findByUserId(user.getUserId())).thenReturn(user);
        UserDao userDao = userService.modifyUserData(user.getUserId(), modifyUserDto);

        //then
        assertEquals(userDao.getNickname(), modifyUserDto.getNickname());
        assertEquals(userDao.getPhoneNumber(), modifyUserDto.getPhoneNumber());
        assertEquals(userDao.getEmail(), modifyUserDto.getEmail());
        assertEquals(user.getPassword(), modifyUserDto.getPassword());
    }
}
