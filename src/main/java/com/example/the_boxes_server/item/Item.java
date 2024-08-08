package com.example.the_boxes_server.item;

import java.util.Date;

import com.example.the_boxes_server.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "Item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId; // ID 필드, 자동 생성

    @Size(max = 100)
    @NotBlank
    private String itemName; // 아이템 이름, 빈 문자열 불가

    @Size(max = 100)
    @NotBlank
    private String itemLocation; // 아이템 위치

    private String classification; // 아이템 분류

    private int amount; // 수량

    private Boolean isActive; // 활성 상태
    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user; // 활성 상태

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt; // 생성 일시

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt; // 업데이트 일시

    @PrePersist
    protected void onCreate() {
        createdAt = new Date(); // 생성 시 일시 설정
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date(); // 업데이트 시 일시 설정
    }
}
