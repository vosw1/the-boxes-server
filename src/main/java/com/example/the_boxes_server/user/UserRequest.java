package com.example.the_boxes_server.user;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

        private String userimg; // 사용자 이미지 URL (선택적)

        @NotEmpty(message = "유저네임이 공백일 수 없습니다")
        private String username;

        @NotEmpty(message = "비밀번호가 공백일 수 없습니다")
        @Size(min = 4, max = 20, message = "비밀번호는 최소 4자 이상 20자 이하여야 합니다")
        private String password;

        @NotEmpty(message = "이름이 공백일 수 없습니다")
        @Size(min = 1, max = 20, message = "이름은 1자 이상 20자 이하여야 합니다")
        private String name;

        @NotEmpty(message = "주소가 공백일 수 없습니다")
        private String address;

        @Email(message = "올바른 이메일 형식이어야 합니다")
        @NotEmpty(message = "이메일이 공백일 수 없습니다")
        private String email;

        @NotNull
        @Past(message = "생년월일은 과거여야 합니다.")
        private LocalDate birthdate; // LocalDate 타입으로 수정

        @NotEmpty(message = "전화번호가 공백일 수 없습니다")
        @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "전화번호 형식이 올바르지 않습니다")
        private String phone;

        @NotEmpty(message = "직책이 공백일 수 없습니다")
        private String position; // 직책을 String으로 유지

        public User toEntity() {
            return User.builder()
                    .username(this.username)
                    .password(this.password)
                    .name(this.name)
                    .address(this.address)
                    .email(this.email)
                    .birthdate(this.birthdate)
                    .phone(this.phone)
                    .position(User.UserPosition.valueOf(this.position))
                    .build();
        }
    }
}