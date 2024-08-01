package com.example.the_boxes_server.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/") // 홈
    public String home() {
        return "";
    }

    @PostMapping("/join") // 회원가입
    public String join() {
        return "/";
    }

    @GetMapping("/api/username-same-check") // 회원가입시 이름 중복체크
    public String usernameSameCheck(String username) {
        return "";
    }

    @PostMapping("/login") // 로그인
    public String login() {
        return "/";
    }

    @GetMapping("/logout") // 로그아웃
    public String logout() {
        //session.invalidate();
        return "redirect:/";
    }
}