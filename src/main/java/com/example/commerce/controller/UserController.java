package com.example.commerce.controller;

import com.example.commerce.entity.dao.UserDao;
import com.example.commerce.entity.dto.SignUpDto;
import com.example.commerce.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(value = "/api/user")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    @ApiOperation(value = "회원가입 API", notes = "정상 동작시 응답 코드 201")
    public ResponseEntity<UserDao> signup(@RequestBody @Valid SignUpDto signUpDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signUp(signUpDto));
    }
}
