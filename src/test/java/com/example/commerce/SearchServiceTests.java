package com.example.commerce;

import com.example.commerce.entity.User;
import com.example.commerce.entity.dao.UserDao;
import com.example.commerce.entity.dto.SignUpDto;
import com.example.commerce.repository.UserRepository;
import com.example.commerce.service.SearchService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTests {
    @InjectMocks
    private SearchService searchService;
    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("회원 조회 성공")
    void successSearchUser() {
        //given
        for (int i = 0; i < 10; i++) {
            SignUpDto dto = SignUpDto.builder()
                    .userId("test" + String.valueOf(i))
                    .password("1234")
                    .name("test" + String.valueOf(i))
                    .nickname("test" + String.valueOf(i))
                    .phoneNumber("010-1234-123" + String.valueOf(i))
                    .email("test" + String.valueOf(i) + "@test.com")
                    .build();

            User user = new User().toUser(dto);
            userRepository.save(user);
        }
        //when
        Page<UserDao> userDao0 = searchService.findAllUser(0, 10, 0);
        Page<UserDao> userDao1 = searchService.findAllUser(0, 5, 1);
        //then
        assertEquals(userDao0.getSize(), userDao1.getSize(), 10);
    }
}
