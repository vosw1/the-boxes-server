package com.example.the_boxes_server.inout;

import com.example.the_boxes_server.user.UserResponse;
import lombok.Data;

import java.time.LocalDateTime;

public class InOutResponse {

    @Data
    public static class ListDTO {
        private Integer inOutId;
        private InOut.OrderType orderType;
        private String changeType;  // Changed to String to store the name of the enum
        private String reason;
        private String status;  // Changed to String to store the name of the enum
        private Integer quantity;
        private LocalDateTime createdAt;
        private UserResponse.LoginDTO  user;

        public ListDTO(InOut inOut) {
            this.inOutId = inOut.getInOutId();
            this.orderType = inOut.getOrderType();
            this.changeType = inOut.getChangeType().name(); // Convert enum to String
            this.reason = inOut.getReason();
            this.status = inOut.getStatus().name(); // Convert enum to String
            this.quantity = inOut.getQuantity();
            this.createdAt = inOut.getCreatedAt();
            this.user = new UserResponse.LoginDTO (inOut.getUser());
        }
    }

    @Data
    public static class SaveDTO {
        private Integer inOutId;
        private InOut.OrderType orderType;
        private String changeType;  // Changed to String to store the name of the enum
        private String reason;
        private String status;  // Changed to String to store the name of the enum
        private Integer quantity;
        private LocalDateTime createdAt;
        private UserResponse.LoginDTO  user;

        public SaveDTO(InOut inOut) {
            this.inOutId = inOut.getInOutId();
            this.orderType = inOut.getOrderType();
            this.changeType = inOut.getChangeType().name(); // Convert enum to String
            this.reason = inOut.getReason();
            this.status = inOut.getStatus().name(); // Convert enum to String
            this.quantity = inOut.getQuantity();
            this.createdAt = inOut.getCreatedAt();
            this.user = new UserResponse.LoginDTO (inOut.getUser());
        }
    }
}