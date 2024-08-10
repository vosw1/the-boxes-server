package com.example.the_boxes_server.inventory;

import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 품목에 대한 현재재고 나타내는 엔티티 클래스
 */
@Entity
@Table(name = "inventory")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    // 재고 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 해당 품목과의 연관관계
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    // 현재 재고 수량
    @Column(name = "current_quantity")
    private Integer currentQuantity;

    // 재고 변경을 수행한 사용자와 연관관계
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 재고 변경 일시
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}