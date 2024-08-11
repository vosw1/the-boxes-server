package com.example.the_boxes_server.inventory;

import com.example.the_boxes_server.item.ItemResponse;
import lombok.Data;

import java.time.LocalDateTime;

public class InventoryResponse {

    @Data
    public static class ListDTO {
        private Integer inventoryId;
        private ItemResponse.ListDTO item;
        private Integer currentQuantity;
        private LocalDateTime createdAt;

        public ListDTO(Inventory inventory) {
            this.inventoryId = inventory.getInventoryId();
            this.item = new ItemResponse.ListDTO(inventory.getItem());
            this.currentQuantity = inventory.getCurrentQuantity();
            this.createdAt = inventory.getCreatedAt();
        }
    }


    public static ListDTO createListDTO(Inventory inventory) {
        return new ListDTO(inventory);
    }
}
