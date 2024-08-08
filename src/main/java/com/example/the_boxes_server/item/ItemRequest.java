package com.example.the_boxes_server.item;

import com.example.the_boxes_server.user.User;
import lombok.Data;

import java.util.Date;

public class ItemRequest {

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
        private Date updatedAt;

        public Item toEntity(User user) {
            return Item.builder().
                    itemId(itemId).
                    itemName(itemName).
                    amount(amount).
                    isActive(isActive)
                    .build();
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
