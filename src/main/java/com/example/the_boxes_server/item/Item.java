package com.example.the_boxes_server.item;

import com.example.the_boxes_server.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "items")
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

    // 아이템 제조사
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
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
