package com.example.the_boxes_server.history;

import com.example.the_boxes_server.inout.InOutResponse;
import com.example.the_boxes_server.inventory.InventoryResponse;
import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.item.ItemResponse;
import lombok.Data;
import java.time.LocalDateTime;

public class HistoryRequest {

    @Data
    public static class ListDTO {
        private Integer historyId;
        private ItemResponse.ListDTO item;
        private InOutResponse.ListDTO inOut;
        private InventoryResponse.ListDTO inventory;
        private LocalDateTime createdAt;

        public ListDTO(History history) {
            this.historyId = history.getHistoryId();
            this.item = new ItemResponse.ListDTO(history.getItem());
            this.inOut = new InOutResponse.ListDTO(history.getInOut());
            this.inventory = new InventoryResponse.ListDTO(history.getInventory());
            this.createdAt = history.getCreatedAt();
        }
    }

    @Data
    public static class FilterDTO {
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Item.ItemStatus status;
    }
}