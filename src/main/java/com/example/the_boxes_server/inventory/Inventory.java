package com.example.the_boxes_server.inventory;

import com.example.the_boxes_server.item.Item;
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
    private Integer id;

    // 아이템
    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    // 과거 수량
    @Column(name = "previous_quantity")
    private Integer previousQuantity;

    // 현재 수량
    @Column(name = "current_quantity")
    private Integer currentQuantity;

    // 입고 수량
    @Column(name = "incoming_quantity")
    private Integer incomingQuantity;

    // 출고 수량
    @Column(name = "outgoing_quantity")
    private Integer outgoingQuantity;

    @Column(name = "date", updatable = false, nullable = false)
    private LocalDateTime date;

    @PrePersist
    protected void onCreate() {
        date = LocalDateTime.now();
    }

    /**
     * 입고 및 출고 수량을 업데이트 -> 재고 조정
     * @param inQuantity  입고 수량
     * @param outQuantity 출고 수량
     */
    public void updateInventory(Integer inQuantity, Integer outQuantity) {
        // null 값이 제공되면 기본값을 0으로 설정
        int incoming = (inQuantity != null) ? inQuantity : 0;
        int outgoing = (outQuantity != null) ? outQuantity : 0;

        // 이전 수량은 현재 수량을 그대로 사용
        this.previousQuantity = this.currentQuantity;

        // 현재 재고 계산
        this.currentQuantity = this.previousQuantity + incoming - outgoing;

        // 입고 및 출고 값 설정
        this.incomingQuantity = incoming;
        this.outgoingQuantity = outgoing;
    }
}