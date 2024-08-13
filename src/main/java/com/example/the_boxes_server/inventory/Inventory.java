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
    public void update(Integer inComing, Integer outGoing) {
        // Validate quantities
        if (inComing == null) {
            inComing = 0;
        }
        if (outGoing == null) {
            outGoing = 0;
        }

        // Calculate new quantity
        Integer newQuantity = this.currentQuantity + inComing - outGoing;

        // Check for negative inventory
        if (newQuantity < 0) {
            throw new IllegalStateException("출고 수량이 재고 수량을 초과할 수 없습니다.");
        }

        // Update current quantity
        this.currentQuantity = newQuantity;
    }
}