package com.example.the_boxes_server.inventory;

import lombok.Data;

public class InventoryResponse {

    @Data
    public class InventoryeDTO {
        private Integer id; // 재고 ID
        private Integer itemId; // 품목 ID
        private Integer previousQuantity; // 변동 전 재고 수량
        private Integer currentQuantity; // 변동 후 재고 수량
        private Integer incomingQuantity; // 입고 수량
        private Integer outgoingQuantity; // 출고 수량
        private Integer userId; // 사용자 ID
        private String createdAt; // 재고 변경 일시
    }
}
