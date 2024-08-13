package com.example.the_boxes_server.user;

import lombok.Data;
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
        private String email; // 이메일
        private String name; // 회원 이름
        private String phone; // 전화번호
        private LocalDateTime createdAt; // 유저 가입 일자
        private User.UserPosition position; // 직책 (Enum 사용)

        public JoinDTO(User user) {
            this.usrId = user.getUserId();
            this.email = user.getEmail();
            this.name = user.getName();
            this.phone = user.getPhone();
            this.createdAt = user.getCreatedAt();
            this.position = user.getPosition(); // 직책 추가
        }
    }
}
