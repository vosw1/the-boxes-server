package com.example.the_boxes_server.history;

import com.example.the_boxes_server.inout.InOut;
import com.example.the_boxes_server.inventory.Inventory;
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
    private Integer historyId;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "in_out_id")
    private InOut inOut;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @Column(name = "previous_quantity")
    private Integer previousQuantity;

    @Column(name = "current_quantity")
    private Integer currentQuantity;

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
