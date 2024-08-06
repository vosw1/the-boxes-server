package com.example.the_boxes_server.inventory;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "inventory")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @NotNull
    private Date summaryDate;

    @Size(max = 50)
    @NotBlank
    private String stockPlace;

    @Size(max = 50)
    @NotBlank
    private String itemCode;

    private Integer oldQuantity;
    private Integer inQuantity;
    private Integer outQuantity;

    @NotNull
    private Integer currentQuantity;

    @Size(max = 255)
    private String remarks;

    @NotNull
    private Date regDate;

    @Size(max = 20)
    @NotBlank
    private String regId;

    @NotNull
    private Date lastDate;

    @Size(max = 20)
    @NotBlank
    private String lastId;
}
