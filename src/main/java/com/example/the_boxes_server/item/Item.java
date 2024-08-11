package com.example.the_boxes_server.item;

import com.example.the_boxes_server.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    // 품목 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    // 품목 이름
    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    // 품목 제조사
    @Column(length = 100)
    private String manufacturer;

    // 품목 위치
    @Column(name = "item_location", length = 100)
    private String itemLocation;

    // 품목 분류
    @Column(length = 100)
    private String classification;

    // 현재 재고 수량
    @Column(name = "current_quantity")
    private Integer currentQuantity;

    // 아이템을 추가한 사용자
    // 품목 등록한 사용자
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 품목 상태 (사용중 또는 사용안함)
    @Enumerated(EnumType.STRING) // ENUM 값을 문자열로 저장
    @Column(name = "status", nullable = false)
    private ItemStatus status;

    // 품목 생성 일시
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        createdAt = LocalDateTime.now(); // 생성 시 현재 시간 설정
    }

    /**
     * 품목 상태를 나타내는 ENUM
     */
    public enum ItemStatus {
        IN_USE,       // 사용중
        NOT_IN_USE    // 사용안함
    }
}