package com.example.commerce.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto {
    @NotBlank
    private String userId;
    @NotBlank
    private String password;
    @NotEmpty
    private String nickname;
    @NotEmpty
    private String name;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;
}
