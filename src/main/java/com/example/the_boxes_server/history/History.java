package com.example.the_boxes_server.history;

import com.example.the_boxes_server.item.Item;
import com.example.the_boxes_server.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 모든 품목들에 대한 기록을 나타내는 엔티티 클래스
 */
@Entity
@Table(name = "history") // 테이블 이름을 "history"로 지정
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성된 ID 값
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id") // 품목 ID와 조인
    private Item item;

    @Enumerated(EnumType.STRING)
    @Column(name = "change_type", nullable = false) // 변동 유형 (입고, 출고, 파손, 기타)
    private ChangeType changeType;

    @Column(name = "reason")
    private String reason; // 변동 유형이 OTHER일 때 사용하는 사유

    public enum ChangeType {
        INCOMING, // 입고
        OUTGOING, // 출고
        DAMAGED,  // 파손
        OTHER     // 기타
    }

    @Column(name = "previous_quantity")
    private Integer previousQuantity; // 변동 전 재고 수량

    @Column(name = "current_quantity")
    private Integer currentQuantity; // 변동 후 재고 수량

    @Column(name = "incoming_quantity")
    private Integer incomingQuantity; // 입고 수량

    @Column(name = "outgoing_quantity")
    private Integer outgoingQuantity; // 출고 수량

    @ManyToOne
    @JoinColumn(name = "user_id") // 변동을 수행한 사용자와 조인
    private User user;

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt; // 변동 일시

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now(); // 변동 내역 생성 시 현재 시간으로 설정
    }

    /**
     * 입고, 출고량에 따른 과거 현재 재고량 업데이트 메소드
     * @param inQuantity 입고 수량
     * @param outQuantity 출고 수량
     */
    public void updateInventory(Integer inQuantity, Integer outQuantity) {
        int incoming = (inQuantity != null) ? inQuantity : 0; // 입고 수량이 null일 경우 0으로 설정
        int outgoing = (outQuantity != null) ? outQuantity : 0; // 출고 수량이 null일 경우 0으로 설정

        this.previousQuantity = this.currentQuantity; // 현재 재고를 이전 재고로 설정
        this.currentQuantity = this.previousQuantity + incoming - outgoing; // 현재 재고 계산
        this.incomingQuantity = incoming; // 입고 수량 설정
        this.outgoingQuantity = outgoing; // 출고 수량 설정
    }
}
