package com.example.the_boxes_server.inventory;

import com.example.the_boxes_server.inout.InOut;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventoryId;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "previous_quantity")
    private Integer previousQuantity;

    @Column(name = "current_quantity")
    private Integer currentQuantity;

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // 재고를 업데이트하는 메서드
    public void update(InOut.OrderType orderType, Integer quantity) {
        // 수량이 null이거나 음수인 경우 예외 발생
        if (quantity == null || quantity < 0) {
            throw new IllegalArgumentException("수량은 0 이상의 정수여야 합니다.");
        }

        // 업데이트 전 현재 재고량 저장
        Integer previousQuantity = this.currentQuantity;

        // 주문 타입에 따라 새로운 재고량 계산
        Integer newQuantity;
        switch (orderType) {
            case INCOMING:
                newQuantity = previousQuantity + quantity;
                break;
            case OUTGOING:
                newQuantity = previousQuantity - quantity;
                // 재고가 부족할 경우 예외 발생
                if (newQuantity < 0) {
                    throw new IllegalStateException("출고 수량이 재고 수량을 초과할 수 없습니다.");
                }
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 주문 타입입니다.");
        }

        // 현재 재고량 업데이트
        this.currentQuantity = newQuantity;
    }
}