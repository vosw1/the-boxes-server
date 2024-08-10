package com.example.the_boxes_server.inventoryhistory;

import com.example.the_boxes_server.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "history")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {

    // 변동 내역 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 변동된 아이템
    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    // 변동 유형(입고, 출고, 파손, 기타)
    @Enumerated(EnumType.STRING)
    @Column(name = "change_type", nullable = false)
    private ChangeType changeType;

    // 변동 유형 기타 사유
    @Column(name = "reason")
    private String reason; // 변동 유형이 기타일 경우에만 사용할 수 있음

    // 변동 유형에 대한 이넘
    public enum ChangeType {
        입고, 출고, 파손, 기타
    }

    // 변동 수량
    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "date", updatable = false, nullable = false)
    private LocalDateTime date;

    @PrePersist
    protected void onCreate() {
        date = LocalDateTime.now();
    }
}