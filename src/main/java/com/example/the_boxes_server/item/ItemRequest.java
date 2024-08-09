package com.example.the_boxes_server.item;

import com.example.the_boxes_server.user.User;
import lombok.Data;
import java.sql.Timestamp;

public class ItemRequest {

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
        private Timestamp createdAt;
    }

    @Data
    public static class SaveDTO {
        private int itemId;
        private String itemName;
        private int amount;
        private String classification;
        private String itemLocation;
        private Boolean isActive;

        private int oldQuantity;
        private int inQuantity;
        private int outQuantity;
        private Timestamp createdAt;

        public Item toEntity(User user) {
            return Item.builder().
                    itemId(itemId).
                    itemName(itemName).
                    itemLocation(itemLocation).
                    classification(classification).
                    amount(amount).
                    oldQuantity(oldQuantity).
                    inQuantity(inQuantity).
                    outQuantity(outQuantity).
                    isActive(isActive)
                    .build();
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

        private int oldQuantity;
        private int inQuantity;
        private int outQuantity;
        private Timestamp createdAt;

        public Item toEntity(User user) {
            return Item.builder().
                    itemId(itemId).
                    itemName(itemName).
                    itemLocation(itemLocation).
                    classification(classification).
                    amount(amount).
                    oldQuantity(oldQuantity).
                    inQuantity(inQuantity).
                    outQuantity(outQuantity).
                    isActive(isActive)
                    .build();
        }
    }

    @Data
    public static class RemoveDTO {
        private int itemId;
        private String itemName;
        private int amount;
        private String classification;
        private String itemLocation;
        private Boolean isActive;
    }
}
