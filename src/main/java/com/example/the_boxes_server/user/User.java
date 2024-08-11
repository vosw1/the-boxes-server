package com.example.the_boxes_server.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Data
@Table(name = "users")
public class User {

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
    private LocalDateTime birthdate;

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
    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private UserPosition position;

    // 사용자 상태 (근무중 / 퇴사한)
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UserStatus status; // WORKING = 근무중, RETIRED = 퇴사한

    @CreationTimestamp
    private LocalDateTime createdAt;

    // 사용자 상태를 나타내는 Enum
    public enum UserStatus {
        WORKING,  // 근무중
        RETIRED   // 퇴사한
    }

    // 직책을 나타내는 Enum
    public enum UserPosition {
        ADMIN,       // 관리자
        MANAGER,     // 매니저
        EMPLOYEE,    // 직원
        INTERN       // 인턴
    }

    @Builder
    public User(
            Integer userId,
            String username,
            String password,
            String name,
            LocalDateTime birthdate,
            String phone,
            String address,
            String email,
            UserPosition position, // 열거형으로 직책
            UserStatus status // 사용자 상태
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
        this.status = status; // 상태 설정
    }
}