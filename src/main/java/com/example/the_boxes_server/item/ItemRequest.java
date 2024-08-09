package com.example.the_boxes_server.item;

import com.example.the_boxes_server.user.User;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ItemRequest {

    @Data
    public static class ListDTO {
        private Integer itemId;
        private String itemName;
        private Integer amount;
        private String classification;
        private String itemLocation;
        private Boolean isActive;
        private Integer oldQuantity;
        private Integer inQuantity;
        private Integer outQuantity;
        private Timestamp createdAt;


        public ListDTO(Integer itemId,String itemName, Integer amount, String classification, String itemLocation, Boolean isActive, Integer oldQuantity, Integer inQuantity, Integer outQuantity, Timestamp createdAt) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.amount = amount;
            this.classification = classification;
            this.itemLocation = itemLocation;
            this.isActive = isActive;
            this.oldQuantity = oldQuantity;
            this.inQuantity = inQuantity;
            this.outQuantity = outQuantity;
            this.createdAt = createdAt;
        }
    }

    @Data
    public static class SaveDTO {
        private String itemName;
        private Integer amount;
        private String classification;
        private String itemLocation;
        private Boolean isActive;
        private Integer oldQuantity;
        private Integer inQuantity;
        private Integer outQuantity;
        private Timestamp createdAt;

        public SaveDTO(String itemName, Integer amount, String classification, String itemLocation, Boolean isActive, Integer oldQuantity, Integer inQuantity, Integer outQuantity, Timestamp createdAt) {
            this.itemName = itemName;
            this.amount = amount;
            this.classification = classification;
            this.itemLocation = itemLocation;
            this.isActive = isActive;
            this.oldQuantity = oldQuantity;
            this.inQuantity = inQuantity;
            this.outQuantity = outQuantity;
            this.createdAt = createdAt;
        }

        public Item toEntity(User user) {
            return Item.builder()
                    .itemName(itemName)
                    .itemLocation(itemLocation)
                    .classification(classification)
                    .amount(amount)
                    .oldQuantity(oldQuantity)
                    .inQuantity(inQuantity)
                    .outQuantity(outQuantity)
                    .isActive(isActive)
                    .createdAt(createdAt)
                    .user(user)
                    .build();
        }
    }

    @Data
    public static class UpdateDTO {
        private Integer itemId;
        private String itemName;
        private Integer amount;
        private String classification;
        private String itemLocation;
        private Boolean isActive;
        private Integer oldQuantity;
        private Integer inQuantity;
        private Integer outQuantity;
        private Timestamp createdAt;

        public UpdateDTO(Integer itemId, String itemName, Integer amount, String classification, String itemLocation, Boolean isActive, Integer oldQuantity, Integer inQuantity, Integer outQuantity, Timestamp createdAt) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.amount = amount;
            this.classification = classification;
            this.itemLocation = itemLocation;
            this.isActive = isActive;
            this.oldQuantity = oldQuantity;
            this.inQuantity = inQuantity;
            this.outQuantity = outQuantity;
            this.createdAt = createdAt;
        }

        public Item toEntity(User user) {
            return Item.builder().itemId(itemId).itemName(itemName).itemLocation(itemLocation).classification(classification).amount(amount).oldQuantity(oldQuantity).inQuantity(inQuantity).outQuantity(outQuantity).isActive(isActive).build();
        }
    }

    @Data
    public static class RemoveDTO {
        private Integer itemId;
        private String itemName;
        private Integer amount;
        private String classification;
        private String itemLocation;
        private Boolean isActive;

        public RemoveDTO(Integer itemId, String itemName, Integer amount, String classification, String itemLocation, Boolean isActive) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.amount = amount;
            this.classification = classification;
            this.itemLocation = itemLocation;
            this.isActive = isActive;
        }
    }
}
