package com.example.the_boxes_server.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // 로그인시 - 이메일, 비밀번호 조회
    Optional<User> findByUsernameAndPassword(@Param("username") String email, @Param("password") String password);

    // 회원 가입
    Optional<User> findByUsername(@Param("username") String email);
}
