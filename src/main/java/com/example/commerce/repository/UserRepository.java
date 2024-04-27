package com.example.commerce.repository;

import com.example.commerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserId(String userId);
    boolean existsByNickname(String nickname);
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByEmail(String email);
    List<User> findAll();
    Optional<User> findByUserId(String userId);
}
