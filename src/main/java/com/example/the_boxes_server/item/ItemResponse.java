package com.example.the_boxes_server.item;

import lombok.Data;
import java.util.Date;

public class ItemResponse {

    @Data
    public static class ListDTO {
        private String itemId;
        private String itemName;
        private int amount;
        private Boolean isActive;
    }


    @Data
    public static class SaveDTO {
        private String itemId;
        private String itemName;
        private int amount;
        private Boolean isActive;
        private Date createdAt;
        private Date updatedAt;

        public SaveDTO(Item item) {
            this.itemId = item.getItemId();
            this.itemName = item.getItemName();
            this.amount = item.getAmount();
            this.isActive = item.getIsActive();
            this.createdAt = item.getCreatedAt();
            this.updatedAt = item.getUpdatedAt();
        }
    }


    @Data
    public static class RemoveDTO {
        private String itemId;
        private String itemName;
        private int amount;
        private Boolean isActive;
    }
}
