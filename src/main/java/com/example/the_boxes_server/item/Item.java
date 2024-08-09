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
    private int itemId;

    @Size(max = 100)
    @NotBlank
    private String itemName;

    @Size(max = 100)
    @NotBlank
    private String itemLocation;

    private int oldQuantity;
    private int inQuantity;
    private int outQuantity;

    private String classification;
    private int amount;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    @Column(name = "created_at", updatable = false, nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 직렬화 형식 지정
    private Timestamp createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }
}

