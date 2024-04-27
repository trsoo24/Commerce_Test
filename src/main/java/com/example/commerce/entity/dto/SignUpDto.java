package com.example.commerce.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto {
    @NotBlank(message = "아이디는 필수 값입니다. 공백은 사용할 수 없습니다.")
    private String userId;
    @NotBlank(message = "비밀번호는 필수 값입니다. 공백은 사용할 수 없습니다.")
    private String password;
    @NotBlank(message = "닉네임은 필수 값입니다. 공백은 사용할 수 없습니다.")
    private String nickname;
    @NotEmpty(message = "이름은 필수 값입니다.")
    private String name;
    @NotBlank(message = "전화번호는 필수 값입니다. 공백은 사용할 수 없습니다.")
    @Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$", message = "010-XXXX-XXXX 양식에 맞춰 작성해주세요.")
    private String phoneNumber;
    @NotBlank(message = "이메일은 필수 값입니다. 공백은 사용할 수 없습니다.")
    @Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", message = "이메일 형식에 맞춰 작성해주세요.")
    private String email;
}
