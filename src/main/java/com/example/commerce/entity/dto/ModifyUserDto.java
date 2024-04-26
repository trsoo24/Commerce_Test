package com.example.commerce.entity.dto;

import com.example.commerce.config.validation.ModifyEmailValidation;
import com.example.commerce.config.validation.ModifyPhoneValidation;
import com.example.commerce.config.validation.ModifyUserInfoValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModifyUserDto {
    @ModifyUserInfoValidation
    private String password;
    @ModifyUserInfoValidation
    private String nickname;
    @ModifyPhoneValidation
    private String phoneNumber;
    @ModifyEmailValidation
    private String email;
}
