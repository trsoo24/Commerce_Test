package com.example.commerce.service;

import com.example.commerce.entity.User;
import com.example.commerce.entity.dao.UserDao;
import com.example.commerce.entity.type.SortType;
import com.example.commerce.exception.CustomCode;
import com.example.commerce.exception.CustomException;
import com.example.commerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.example.commerce.exception.CustomCode.*;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final UserRepository userRepository;

    /** 유저 전체 조회 API
     * @param page = 페이지 번호
     * @param pageSize = 한 페이지에 표시하는 최대 회원 수
     * @param sortType = { 가입일 순, 이름 순 }
     */
    public Page<UserDao> findAllUser(int page, int pageSize, SortType sortType) {
        List<User> userList = userRepository.findAll();
        List<UserDao> userDaoList = new ArrayList<>();

        if (checkPageNegative(page)) throw new CustomException(NEGATIVE_PAGE_VALUE);
        if (checkPageSizeNegative(pageSize)) throw new CustomException(NEGATIVE_PAGE_SIZE_VALUE);

        for (User user : userList) {
            UserDao userDao = new UserDao().toDao(user);
            userDaoList.add(userDao);
        }

        if (sortType.getSortType().equals("REGISTERED")) { // 가입일 순
            return sortByRegisteredAt(page, pageSize, userDaoList);
        } else if (sortType.getSortType().equals("NAME")){ // 이름 순
            return sortByName(page, pageSize, userDaoList);
        } else {
            throw new CustomException(SORT_ERROR);
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
        return new PageImpl<>(userList.subList(start, userList.size()), pageRequest, userList.size());
    }

    private boolean checkPageNegative(int page) {
        return page < 0;
    }

    private boolean checkPageSizeNegative(int pageSize) {
        return pageSize <= 0;
    }
}
