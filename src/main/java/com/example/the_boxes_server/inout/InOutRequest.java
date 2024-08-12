package com.example.the_boxes_server.inout;

import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@Getter
@Setter
public class InOutRequest {

    @Data
    public static class SaveDTO {
        private Integer inOutId;
        private InOut.OrderType orderType;
        private InOut.ChangeType changeType;
        private String reason;
        private Integer quantity;
        private InOut.OrderStatus status;
        private LocalDateTime createdAt;
        private User user;
        private Integer itemId;  // Changed from Item to itemId

        public SaveDTO() {
        }

        public SaveDTO(InOut inOut) {
            this.inOutId = inOut.getInOutId();
            this.changeType = inOut.getChangeType();
            this.orderType = inOut.getOrderType();
            this.status = inOut.getStatus();
            this.reason = inOut.getReason();
            this.quantity = inOut.getQuantity();
            this.createdAt = inOut.getCreatedAt();
            this.itemId = inOut.getItem() != null ? inOut.getItem().getItemId() : null; // Assuming Item has getItemId method
        }

        public InOut toEntity(User sessionUser, Item item) {
            return InOut.builder()
                    .inOutId(this.inOutId)
                    .orderType(this.orderType)
                    .quantity(this.quantity)
                    .changeType(this.changeType)
                    .reason(this.reason)
                    .status(this.status)
                    .createdAt(this.createdAt)
                    .item(item)
                    .user(sessionUser)
                    .build();
        }
    }
}