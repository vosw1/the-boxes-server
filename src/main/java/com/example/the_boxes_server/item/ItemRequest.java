package com.example.the_boxes_server.item;

import com.example.the_boxes_server.user.User;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ItemRequest {

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
        private String itemName;
        private String classification;
        private String itemLocation;
        private String manufacturer;
        private Item.ItemStatus status;
        private User user;

        public Item toEntity(User sessionUser) {
            return Item.builder()
                    .itemName(itemName)
                    .classification(classification)
                    .itemLocation(itemLocation)
                    .manufacturer(manufacturer)
                    .status(status)
                    .user(sessionUser) // Associate user with the item
                    .build();
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

        // Jackson이 기본 생성자 필요 -> 없으면 에러남
        public UpdateDTO() {
        }

        // 기존 생성자 (옵션)
        public UpdateDTO(Item item) {
            this.itemId = item.getItemId();
            this.itemName = item.getItemName();
            this.classification = item.getClassification();
            this.itemLocation = item.getItemLocation();
            this.manufacturer = item.getManufacturer();
            this.status = item.getStatus();
        }
    }


    @Data
    public static class RemoveDTO {
        private Integer itemId;
        private String itemName;
        private String classification;
        private String itemLocation;
        private Item.ItemStatus status;

        public RemoveDTO(Item item) {
            this.itemId = item.getItemId();
            this.itemName = item.getItemName();
            this.classification = item.getClassification();
            this.itemLocation = item.getItemLocation();
            this.status = item.getStatus();
        }
    }
}
