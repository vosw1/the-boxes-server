package com.example.the_boxes_server.item;

import com.example.the_boxes_server.user.UserResponse;
import lombok.Data;
import java.time.LocalDateTime;

public class ItemResponse {

    @Data
    public static class ListDTO {
        private Integer itemId; // 품목 ID
        private String itemName; // 품목 이름
        private String manufacturer; // 제조사
        private String itemLocation; // 품목 위치
        private String classification; // 품목 분류
        private String status; // 품목 상태

        public ListDTO(Item item) {
            this.itemId = item.getItemId();
            this.itemName = item.getItemName();
            this.manufacturer = item.getManufacturer();
            this.itemLocation = item.getItemLocation();
            this.classification = item.getClassification();
            this.status = item.getStatus().name();
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
