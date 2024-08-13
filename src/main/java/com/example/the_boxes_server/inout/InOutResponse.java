package com.example.the_boxes_server.inout;

import com.example.the_boxes_server.user.User;
import com.example.the_boxes_server.user.UserResponse;
import lombok.Data;

import java.time.LocalDateTime;

public class InOutResponse {

    @Data
    public static class ListDTO {
        private Integer inOutId;
        private String other;
        private InOut.OrderStatus status;
        private Integer inComing;
        private Integer outComing;
        private LocalDateTime createdAt;
        private UserResponse.LoginDTO user;

        public ListDTO(InOut inOut) {
            this.inOutId = inOut.getInOutId();
            this.other = inOut.getOther();
            this.status = inOut.getStatus();
            this.inComing = inOut.getInComing();
            this.outComing = inOut.getOutComing();
            this.createdAt = inOut.getCreatedAt();
            this.user = inOut.getUser() != null ? new UserResponse.LoginDTO(inOut.getUser()) : null;
        }
    }

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
            this.itemId = inOut.getItem() != null ? inOut.getItem().getItemId() : null; // Assuming Item has getItemId method
        }
    }
}
