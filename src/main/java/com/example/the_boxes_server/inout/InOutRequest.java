package com.example.the_boxes_server.inout;

import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@Data
public class InOutRequest {

    @Data
    public static class SaveDTO {
        private Integer inOutId;
        private String other;
        private InOut.OrderStatus status;
        private Integer inComing;
        private Integer outComing;
        private LocalDateTime createdAt;
        private User user;
        private Integer itemId;  // Changed from Item to itemId

        public SaveDTO() {
        }

        public SaveDTO(InOut inOut) {
            this.inOutId = inOut.getInOutId();
            this.other = inOut.getOther();
            this.status = inOut.getStatus();
            this.inComing = inOut.getInComing();
            this.outComing = inOut.getOutComing();
            this.createdAt = inOut.getCreatedAt();
            this.user = inOut.getUser();
            this.itemId = inOut.getItem() != null ? inOut.getItem().getItemId() : null; // Assuming Item has getItemId method
        }

        public InOut toEntity(User sessionUser, Item item) {
            return InOut.builder()
                    .inOutId(this.inOutId)
                    .inComing(this.inComing)
                    .outComing(this.outComing)
                    .other(this.getOther())
                    .status(this.status)
                    .createdAt(this.createdAt)
                    .item(item)
                    .user(sessionUser)
                    .build();
        }
    }
}