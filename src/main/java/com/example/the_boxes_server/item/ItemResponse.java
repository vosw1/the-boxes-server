package com.example.the_boxes_server.item;

import lombok.Data;
import java.util.Date;

public class ItemResponse {

    @Data
    public static class ListDTO {
        private int itemId;
        private String itemName;
        private int amount;
        private String classification;
        private String itemLocation;
        private Boolean isActive;

        private int oldQuantity;
        private int inQuantity;
        private int outQuantity;

        public ListDTO(Item item) {
            this.itemId = item.getItemId();
            this.itemName = item.getItemName();
            this.amount = item.getAmount();
            this.oldQuantity = item.getOldQuantity();
            this.outQuantity = item.getOutQuantity();
            this.inQuantity = item.getInQuantity();
            this.itemLocation = item.getItemLocation();
            this.isActive = item.getIsActive();
        }
    }


    @Data
    public static class SaveDTO {
        private int itemId;
        private String itemName;
        private int amount;
        private String classification;
        private String itemLocation;
        private Boolean isActive;
        private Date createdAt;
        private Date updatedAt;

        public SaveDTO(Item item) {
            this.itemId = item.getItemId();
            this.itemName = item.getItemName();
            this.amount = item.getAmount();
            this.classification = item.getClassification();
            this.itemLocation = item.getItemLocation();
            this.isActive = item.getIsActive();
            this.createdAt = item.getCreatedAt();
        }
    }


    @Data
    public static class RemoveDTO {
        private int itemId;
        private String itemName;
        private String classification;
        private int amount;
        private String itemLocation;
        private Boolean isActive;
        private Date updatedAt;

        public RemoveDTO(Item item) {
            this.itemId = item.getItemId();
            this.itemName = item.getItemName();
            this.amount = item.getAmount();
            this.classification = item.getClassification();
            this.itemLocation = item.getItemLocation();
            this.isActive = item.getIsActive();
        }
    }

    @Data
    public static class UpdateDTO {
        private int itemId;
        private String itemName;
        private int amount;
        private String classification;
        private String itemLocation;
        private Boolean isActive;
        private Date createdAt;

        public UpdateDTO(Item item) {
            this.itemId = item.getItemId();
            this.itemName = item.getItemName();
            this.amount = item.getAmount();
            this.classification = item.getClassification();
            this.itemLocation = item.getItemLocation();
            this.isActive = item.getIsActive();
            this.createdAt = item.getCreatedAt();
        }
    }
}
