package com.example.the_boxes_server.inout;

import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 입출고 지시를 나타내는 엔티티 클래스
 */
@Entity
@Table(name = "in_out")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InOut {

    // 입출고 지시 ID (기본키)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 지시 유형 (입고 또는 출고)
    @Enumerated(EnumType.STRING)
    @Column(name = "order_type", nullable = false)
    private OrderType orderType;

    // 연관된 품목
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    // 지시된 수량
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // 지시 상태 (대기, 승인, 배송, 도착)
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    // 지시 생성 일시
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    // 지시를 생성한 사용자
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now(); // 생성 시 현재 시간 설정
    }

    /**
     * 지시 유형을 나타내는 ENUM
     */
    public enum OrderType {
        INCOMING, // 입고
        OUTGOING  // 출고
    }

    /**
     * 지시 상태를 나타내는 ENUM
     */
    public enum OrderStatus {
        PENDING,  // 대기
        APPROVED, // 승인
        SHIPPED,  // 배송
        DELIVERED // 도착
    }
}