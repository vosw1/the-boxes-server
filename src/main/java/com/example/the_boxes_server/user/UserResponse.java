package com.example.the_boxes_server.user;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserResponse {

    @Data
    public static class LoginDTO {
        private Integer usrId; // 유저 ID
        private String name; // 회원 이름
        private User.UserPosition position; // 직책 (Enum 사용)
        private User.UserStatus status; // 전화번호
        private String phone; // 전화번호

        public LoginDTO(User sessionUser) {
            this.usrId = sessionUser.getUserId();
            this.name = sessionUser.getName();
            this.position = sessionUser.getPosition();
            this.status = sessionUser.getStatus();
            this.phone = sessionUser.getPhone();
        }
        public User toEntity() {
            return User.builder()
                    .userId(this.usrId)
                    .username(this.name)
                    .position(this.position)
                    .status(this.status)
                    .name(this.phone)
                    .build();
        }
    }

    @Data
    public static class JoinDTO {
        private Integer usrId; // 유저 ID
        private String name; // 회원 이름
        private LocalDate birthdate; // 생년월일
        private String phone; // 전화번호
        private String address; // 주소
        private String email; // 이메일
        private User.UserPosition position; // 직책 (Enum 사용)
        private User.UserStatus status; // 상태 (Enum 사용)
        private LocalDateTime createdAt; // 유저 가입 일자

        public JoinDTO(User user) {
            this.usrId = user.getUserId();
            this.name = user.getName();
            this.birthdate = user.getBirthdate();
            this.phone = user.getPhone();
            this.address = user.getAddress();
            this.email = user.getEmail();
            this.position = user.getPosition();
            this.status = user.getStatus(); // User의 상태를 가져옵니다.
            this.createdAt = user.getCreatedAt(); // 유저 가입 일자
        }
    }
}