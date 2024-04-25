package com.example.commerce.entity.dao;


import com.example.commerce.entity.dto.SignUpDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "회원가입 응답 값")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDao {
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
