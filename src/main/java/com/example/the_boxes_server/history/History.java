package com.example.the_boxes_server.history;

import com.example.the_boxes_server.inout.InOut;
import com.example.the_boxes_server.inventory.Inventory;
import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 모든 품목들에 대한 기록을 나타내는 엔티티 클래스
 */
@Entity
@Table(name = "history") // 테이블 이름을 "history"로 지정
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성된 ID 값
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id") // 품목 ID와 조인
    private Item item;

    @ManyToOne
    @JoinColumn(name = "user_id") // 변동을 수행한 사용자와 조인
    private User user;

    @ManyToOne
    @JoinColumn(name = "inventory_id") // 인벤토리 ID와 조인
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "in_out_id") // 입출고 ID와 조인
    private InOut inOut;

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt; // 변동 일시

    // 편의 메서드
    public Integer getPreviousQuantity() {
        return inventory != null ? inventory.getPreviousQuantity() : null;
    }

    public Integer getCurrentQuantity() {
        return inventory != null ? inventory.getCurrentQuantity() : null;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now(); // 변동 내역 생성 시 현재 시간으로 설정
    }
}