package com.example.the_boxes_server.inventory;

import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.user.User;
import lombok.Data;

import java.time.LocalDateTime;

public class InventoryResponse {

    @Data
    public class ListDTO {
        private Integer inventoryId; // 품목 ID
        private Item item; // 품목 ID
        private Integer previousQuantity; // 변동 전 재고 수량
        private Integer currentQuantity; // 변동 후 재고 수량
        private User user; // 사용자 ID
        private LocalDateTime createdAt; // 사유 (선택적)

        public ListDTO(Inventory inventory) {
            this.inventoryId = inventory.getInventoryId();
            this.item = inventory.getItem();
            this.previousQuantity = inventory.getPreviousQuantity();
            this.currentQuantity = inventory.getCurrentQuantity();
            this.user = inventory.getUser();
            this.createdAt = inventory.getCreatedAt();
        }
    }

    public static ListDTO createListDTO(Inventory inventory) {
        return new InventoryResponse().new ListDTO(inventory);
    }
}