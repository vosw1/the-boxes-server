package com.example.the_boxes_server.incoming;

import com.example.the_boxes_server.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "in_coming")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InComing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inComingId;  // 입고 ID (기본 키, 자동 증가)

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;  // 품목 (외래 키)

    @Column(name = "incoming_quantity", nullable = false)
    private Integer inComingQuantity;  // 입고 수량

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;  // 입고 단가

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;  // 입고 날짜
}
