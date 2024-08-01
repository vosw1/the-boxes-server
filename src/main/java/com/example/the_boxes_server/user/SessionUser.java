package com.example.the_boxes_server.user;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class SessionUser {
    private Integer id; // 유저 번호
    private String email; // 이메일 (로그인 할 때 아이디로 사용)
    private String name; // 회원 이름
    private String phone; // 전화번호
    private LocalDate birth; // 생년월일
    private LocalDateTime createdAt; // 유저 가입 일자

    @Builder
    public SessionUser(Integer id, String email, String name, String phone, LocalDate birth, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.createdAt = createdAt;
    }

    public SessionUser(User user) {
        this.id = user.getUserId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.phone = user.getPhone();
    }

}
