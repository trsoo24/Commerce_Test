package com.example.commerce.entity.dao;


import com.example.commerce.entity.dto.SignUpDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDao {
    private String userId;
    private String nickname;
    private String name;
    private String phoneNumber;
    private String email;

    public SignUpDao toDao (SignUpDto dto) {
        return SignUpDao.builder()
                .userId(dto.getUserId())
                .nickname(dto.getNickname())
                .name(dto.getName())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .build();
    }
}
