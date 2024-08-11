package com.example.the_boxes_server.inventory;

import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.item.ItemResponse;
import com.example.the_boxes_server.user.User;
import lombok.Data;

import java.time.LocalDateTime;

public class InventoryResponse {

    // 전체 및 조건별 조회
    @Data
    public class ListDTO {
        private Integer inventoryId; // 재고 ID
        private ItemResponse.ListDTO item; // 품목 정보
        private Integer currentQuantity; // 현재 재고 수량
        private LocalDateTime createdAt; // 생성 일시

        public ListDTO(Inventory inventory) {
            this.inventoryId = inventory.getInventoryId();
            this.item = new ItemResponse.ListDTO(inventory.getItem());
            this.currentQuantity = inventory.getCurrentQuantity();
            this.createdAt = inventory.getCreatedAt();
        }
    }

    public static ListDTO createListDTO(Inventory inventory) {
        return new InventoryResponse().new ListDTO(inventory);
    }
}