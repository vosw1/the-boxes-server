package com.example.the_boxes_server.item;

import lombok.Data;
import java.time.LocalDateTime;

public class ItemResponse {

    @Data
    public static class ListDTO {
        private Integer itemId;
        private String itemName;
        private String classification;
        private String itemLocation;
        private String manufacturer;
        private Item.ItemStatus status;
        private LocalDateTime createdAt;

        public ListDTO(Item item) {
            this.itemId = item.getItemId();
            this.itemName = item.getItemName();
            this.classification = item.getClassification();
            this.itemLocation = item.getItemLocation();
            this.manufacturer = item.getManufacturer();
            this.status = item.getStatus();
            this.createdAt = item.getCreatedAt();
        }
    }

    @Data
    public static class SaveDTO {
        private Integer itemId;
        private String itemName;
        private String classification;
        private String itemLocation;
        private String manufacturer;
        private Item.ItemStatus status;
        private LocalDateTime createdAt;

        public SaveDTO(Item item) {
            this.itemId = item.getItemId();
            this.itemName = item.getItemName();
            this.classification = item.getClassification();
            this.itemLocation = item.getItemLocation();
            this.manufacturer = item.getManufacturer();
            this.status = item.getStatus();
            this.createdAt = item.getCreatedAt();
        }
    }

    @Data
    public static class UpdateDTO {
        private Integer itemId;
        private String itemName;
        private String classification;
        private String itemLocation;
        private String manufacturer;
        private Item.ItemStatus status;
        private LocalDateTime createdAt;

        public UpdateDTO(Item item) {
            this.itemId = item.getItemId();
            this.itemName = item.getItemName();
            this.classification = item.getClassification();
            this.itemLocation = item.getItemLocation();
            this.manufacturer = item.getManufacturer();
            this.status = item.getStatus();
            this.createdAt = item.getCreatedAt();
        }
    }

    @Data
    public static class RemoveDTO {
        private Integer itemId;
        private String itemName;
        private String classification;
        private String itemLocation;
        private String manufacturer;
        private Item.ItemStatus status;

        public RemoveDTO(Item item) {
            this.itemId = item.getItemId();
            this.itemName = item.getItemName();
            this.classification = item.getClassification();
            this.itemLocation = item.getItemLocation();
            this.manufacturer = item.getManufacturer();
            this.status = item.getStatus();
        }
    }
}
