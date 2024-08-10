package com.example.the_boxes_server.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Data
@Table(name = "users")
public class User {

    // 사용자 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    // 사용자 아이디
    @Column(unique = true, length = 50, nullable = false)
    private String username;

    // 사용자 비밀번호
    @Column(length = 60, nullable = false)
    private String password;

    // 사용자 이름
    @Column(length = 20, nullable = false)
    private String name;

    // 사용자 생년월일
    @Column(name = "birthdate")
    private LocalDate birthdate;

    // 사용자 전화번호
    @Column(length = 20)
    private String phone;

    // 사용자 주소
    @Column(length = 255)
    private String address;

    // 사용자 이메일
    @Column(length = 100, nullable = false)
    private String email;

    // 사용자 직책
    @Column(length = 50)
    private String position;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public User(
            Integer userId,
            String username,
            String password,
            String name,
            LocalDate birthdate,
            String phone,
            String address,
            String email,
            String position
    ) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthdate = birthdate;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.position = position;
    }
}