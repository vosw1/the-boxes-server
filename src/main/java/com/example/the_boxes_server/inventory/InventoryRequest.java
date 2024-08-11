package com.example.the_boxes_server.inventory;

import com.example.the_boxes_server.item.Item;
import lombok.Data;

import java.time.LocalDateTime;

public class InventoryRequest {

    // 전체 및 조건별 조회
    @Data
    public class InventoryeDTO {
        private Integer inventoryId; // 품목 ID
        private Item item; // 품목 ID
        private Integer currentQuantity; // 변동 후 재고 수량
        private LocalDateTime createdAt; // 사유 (선택적)

        public InventoryeDTO(Inventory inventory) {
            this.inventoryId = inventory.getInventoryId();
            this.item = inventory.getItem();
            this.currentQuantity = inventory.getCurrentQuantity();
            this.createdAt = inventory.getCreatedAt();
        }
    }
}