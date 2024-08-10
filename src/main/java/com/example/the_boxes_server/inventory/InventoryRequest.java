package com.example.the_boxes_server.inventory;

import com.example.the_boxes_server.inout.InOut;
import lombok.Data;

public class InventoryRequest {

    @Data
    public class InventoryeDTO {
        private Integer itemId; // 품목 ID
        private Integer quantity; // 입고/출고 수량
        private InOut.OrderType orderType; // 입고 또는 출고 타입
        private Integer userId; // 사용자 ID
        private String reason; // 사유 (선택적)
    }
}
