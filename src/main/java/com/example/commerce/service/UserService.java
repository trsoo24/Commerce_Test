package com.example.commerce.service;

import com.example.commerce.entity.User;
import com.example.commerce.entity.dao.UserDao;
import com.example.commerce.entity.dto.SignUpDto;
import com.example.commerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CheckUserReference checkUserReference;

    @Transactional
    public UserDao signUp (SignUpDto signUpDto) {
        checkUserReference.existUserId(signUpDto.getUserId());
        checkUserReference.existNickname(signUpDto.getNickname());
        checkUserReference.existPhoneNumber(signUpDto.getPhoneNumber());
        checkUserReference.checkEmail(signUpDto.getEmail());

        User user = new User().toUser(signUpDto);
        userRepository.save(user);

        return new UserDao().toDao(user);
    }


}
