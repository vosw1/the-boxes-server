package com.example.the_boxes_server.user;

import lombok.Data;
import java.time.LocalDateTime;

public class UserResponse {

    @Data
    public static class LoginDTO {
        private Integer id; // 유저 번호
        private String username; // 유저 이름
        private String email; // 이메일 (로그인 할 때 아이디로 사용)
        private String name; // 회원 이름
        private String phone; // 전화번호
        private LocalDateTime createdAt; // 유저 가입 일자

        public LoginDTO(User user) {
            this.id = user.getUserId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.name = user.getName();
            this.phone = user.getPhone();
            this.createdAt = user.getCreatedAt();
        }
    }

    @Data
    public static class JoinDTO {
        private Integer id; // 유저 번호
        private String email; // 이메일 (로그인 할 때 아이디로 사용)
        private String name; // 회원 이름
        private String phone; // 전화번호
        private LocalDateTime createdAt; // 유저 가입 일자

        public JoinDTO(User user) {
            this.id = user.getUserId();
            this.email = user.getEmail();
            this.name = user.getName();
            this.phone = user.getPhone();
            this.createdAt = user.getCreatedAt();
        }
    }
}
