package com.example.commerce.controller;

import com.example.commerce.entity.dao.SignUpDao;
import com.example.commerce.entity.dto.SignUpDto;
import com.example.commerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<SignUpDao> signup(@RequestBody @Valid SignUpDto signUpDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signUp(signUpDto));
    }
}
