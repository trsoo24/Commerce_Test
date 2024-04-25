package com.example.commerce.entity.dao;


import com.example.commerce.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(description = "회원가입 응답 값")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDao {
    @Schema(description = "아이디")
    private String userId;
    @Schema(description = "닉네임")
    private String nickname;
    @Schema(description = "이름")
    private String name;
    @Schema(description = "전화번호")
    private String phoneNumber;
    @Schema(description = "이메일")
    private String email;
    private LocalDateTime registeredAt;

    public UserDao toDao (User user) {
        return UserDao.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .registeredAt(user.getRegisteredAt())
                .build();
    }
}
