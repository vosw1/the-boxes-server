package com.example.the_boxes_server.inventory;

import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private Integer inventoryId;

    // 해당 품목과의 연관관계
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    // 변동 전 재고 수량
    @Column(name = "previous_quantity")
    private Integer previousQuantity;

    // 변동 후 재고 수량
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

    // 재고 업데이트 메서드 (현재 재고량 변경)
    public void updateInventory(Integer inQuantity, Integer outQuantity) {
        // 입고 및 출고 수량이 null인 경우 0으로 설정
        int incoming = (inQuantity != null) ? inQuantity : 0;
        int outgoing = (outQuantity != null) ? outQuantity : 0;

        // 이전 재고량을 현재 재고량으로 설정
        Integer previousQuantity = this.currentQuantity;

        // 현재 재고량 계산
        this.currentQuantity = previousQuantity + incoming - outgoing;

        // 필요한 경우 입고 및 출고 수량 설정 (추가 필드 필요)
    }
}
