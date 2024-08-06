package com.example.the_boxes_server.instruction;

import java.util.Date;

import com.example.the_boxes_server.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "instruction")
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receivingItemId;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @Size(max = 50)
    @NotBlank
    private String itemCode;

    @Size(max = 50)
    private String lotNo;

    @NotNull
    private Integer quantity;

    @Size(max = 50)
    @NotBlank
    private String stockPlace;

    @NotNull
    private Character qcStatus;

    @NotNull
    private Character inStatus;

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
