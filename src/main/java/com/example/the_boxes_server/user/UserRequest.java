package com.example.the_boxes_server.user;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

public class UserRequest {

    // 로그인
    @Data
    public static class LoginDTO {
        @NotEmpty(message = "유저네임이 공백일 수 없습니다")
        @Size(min = 1, max = 20, message = "유저네임은 최소 1자 이상 최대 20자 이하여야 합니다")
        private String username;

        @NotEmpty(message = "비밀번호가 공백일 수 없습니다")
        @Size(min = 4, max = 20, message = "비밀번호는 최소 4자 이상 최대 20자 이하여야 합니다")
        private String password;
    }

    // 회원가입
    @Data
    @NoArgsConstructor
    public static class JoinDTO {

        private String userimg;

        @NotEmpty(message = "유저네임이 공백일 수 없습니다")
        private String username;

        @NotEmpty(message = "비밀번호가 공백일 수 없습니다")
        @Size(min = 4, max = 20, message = "비밀번호는 최소 4자 이상 20장 이하여야 합니다")
        private String password;

        @NotEmpty(message = "이름이 공백일 수 없습니다")
        @Size(min = 1, max = 20, message = "이름은 1자 이상 20자 이하여야 합니다")
        private String name;

        @NotEmpty(message = "주소가 공백일 수 없습니다")
        private String address;

        @Email(message = "올바른 이메일 형식이어야 합니다")
        @NotEmpty(message = "email이 공백일 수 없습니다")
        private String email;

        @NotNull
        @Past(message = "날짜는 과거여야 합니다.")
        private Date birth;

        @NotEmpty(message = "전화번호가 공백일 수 없습니다")
        @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "전화번호 형식이 올바르지 않습니다")
        private String phone;

        @NotEmpty(message = "회사명이 공백일 수 없습니다")
        @Size(min = 1, max = 20, message = "회사명은 1자 이상 20자 이하여야 합니다")
        private String compname;

        @NotEmpty(message = "업종이 공백일 수 없습니다")
        @Size(min = 1, max = 20, message = "업종은 1자 이상 20자 이하여야 합니다")
        private String industry;

        @NotEmpty(message = "물류센터 주소가 공백일 수 없습니다")
        private String cenaddress;

        @NotNull
        private Integer position;

        @NotNull
        private Integer equipment;
    }
}
