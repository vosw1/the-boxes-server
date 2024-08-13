package com.example.the_boxes_server.inout;

import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "in_out")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InOut {

    // 입출고 지시 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inOutId;

    // 입고수
    @Column(name = "in_coming", nullable = false)
    private int inComing;

    // 출고수
    @Column(name = "out_coming", nullable = false)
    private int outComing;

    // 지시 변동 유형
    @Enumerated(EnumType.STRING)
    @Column(name = "change_type")
    private ChangeType changeType;

    // 변동 유형이 OTHER일 때 사용하는 사유
    @Column(name = "reason")
    private String reason;

    // 연관된 품목
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    // 지시 상태 (대기, 승인, 배송, 도착)
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

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

    public enum ChangeType {
        STOCK_ADDITION, // 재고 추가
        STOCK_REMOVAL,  // 재고 출고/판매
        DAMAGE,         // 재고 손상
        OTHER           // 기타
    }

    public enum OrderStatus {
        PENDING,  // 대기
        APPROVED, // 승인
        SHIPPED,  // 배송
        DELIVERED // 도착
    }
}