package com.example.the_boxes_server.item;

import java.sql.Timestamp;
import com.example.the_boxes_server.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @Size(max = 100)
    @NotBlank
    private String itemName;

    @Size(max = 100)
    @NotBlank
    private String itemLocation;

    private Integer oldQuantity; // 과거 재고
    private Integer inQuantity;  // 입고 재고
    private Integer outQuantity; // 출고 재고

    private String classification;
    private Integer amount;      // 현재 재고
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    @Column(name = "created_at", updatable = false, nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    public void updateStock(Integer inQuantity, Integer outQuantity) {
        // `null` 값이 제공되면 기본값을 0으로 설정
        int incoming = (inQuantity != null) ? inQuantity : 0;
        int outgoing = (outQuantity != null) ? outQuantity : 0;

        // 재고 업데이트를 통해 현재 재고(amount) 계산
        this.oldQuantity = this.amount; // 이전 재고를 현재 재고로 설정

        // 현재 재고 계산
        this.amount = this.oldQuantity + incoming - outgoing;

        // 입고 및 출고 값 설정
        this.inQuantity = incoming;
        this.outQuantity = outgoing;
    }
}