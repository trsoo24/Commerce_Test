package com.example.commerce.controller;

import com.example.commerce.entity.dao.UserDao;
import com.example.commerce.entity.dto.ModifyUserDto;
import com.example.commerce.entity.dto.SignUpDto;
import com.example.commerce.service.SearchService;
import com.example.commerce.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Api(value = "/api/user")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final SearchService searchService;

    @PostMapping("/join")
    @ApiOperation(value = "회원가입 API", notes = "정상 동작시 응답 코드 201")
    public ResponseEntity<UserDao> signup(@RequestBody @Valid SignUpDto signUpDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signUp(signUpDto));
    }

    @GetMapping("/list")
    @ApiOperation(value = "유저 조회 API")
    public ResponseEntity<Page<UserDao>> findAllUser(@RequestParam @Min(value = 0, message = "최소값은 0 입니다.") @Valid int page,
                                                     @RequestParam @Min(value = 1, message = "최소값은 0 입니다.") @Valid int pageSize,
                                                     @RequestParam @Min(value = 0, message = "가입일 순은 0 입니다.") @Max(value = 1, message = "이름 순은 1 입니다.") @Valid int sort) {
        return ResponseEntity.ok(searchService.findAllUser(page, pageSize, sort));
    }

    @PatchMapping("/{userId}")
    @ApiOperation(value = "유저 정보 수정 API")
    public ResponseEntity<UserDao> modifyUser(@PathVariable("userId") String userId,
                                              @RequestBody @Valid ModifyUserDto modifyUserDto) {
        return ResponseEntity.ok(userService.modifyUserData(userId, modifyUserDto));
    }
}
