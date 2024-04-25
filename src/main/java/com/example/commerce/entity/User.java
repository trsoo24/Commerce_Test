package com.example.commerce.entity;

import com.example.commerce.entity.dto.SignUpDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userId;
    private String password;
    @Column(unique = true)
    private String nickname;
    private String name;
    @Column(unique = true)
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private LocalDateTime registeredAt;

    public User toUser(SignUpDto dto) {
        return User.builder()
                .userId(dto.getUserId())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .name(dto.getName())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
    }
}
