package com.example.commerce.service;

import com.example.commerce.entity.User;
import com.example.commerce.entity.dao.UserDao;
import com.example.commerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final UserRepository userRepository;

    /** 유저 전체 조회 API
     * @param page = 페이지 번호
     * @param pageSize = 한 페이지에 표시하는 최대 회원 수
     * @param sort = { 0 = 가입일 순, 1 = 이름 순 }
     */
    public Page<UserDao> findAllUser(int page, int pageSize, int sort) {
        List<User> userList = userRepository.findAll();
        List<UserDao> userDaoList = new ArrayList<>();

        for (User user : userList) {
            UserDao userDao = new UserDao().toDao(user);
            userDaoList.add(userDao);
        }

        if (sort == 0) { // 가입일 순
            return sortByRegisteredAt(page, pageSize, userDaoList);
        } else { // 이름 순
            return sortByName(page, pageSize, userDaoList);
        }
    }

    private Page<UserDao> sortByRegisteredAt(int page, int pageSize, List<UserDao> userDaoList) {
        Comparator<UserDao> byRegisteredAt = Comparator.comparing(UserDao::getRegisteredAt);
        userDaoList.sort(byRegisteredAt);

        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return listToPage(userDaoList, pageRequest);
    }
    private Page<UserDao> sortByName(int page, int pageSize, List<UserDao> userDaoList) {
        Comparator<UserDao> byName = Comparator.comparing(UserDao::getName);
        userDaoList.sort(byName);

        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return listToPage(userDaoList, pageRequest);
    }

    private Page<UserDao> listToPage(List<UserDao> userList, PageRequest pageRequest) {
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), userList.size());
        return new PageImpl<>(userList.subList(start, end), pageRequest, userList.size());
    }
}
