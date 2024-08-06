package com.example.the_boxes_server.inout;

import com.example.the_boxes_server.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Entity
@Data
@Table(name = "inout")
public class Inout {
    @Id
    @Size(max = 14)
    private String receivingCode;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @Size(max = 50)
    @NotBlank
    private String customerCode;

    @NotNull
    private Date workDate;

    @Size(max = 20)
    @NotBlank
    private String workerId;

    @Size(max = 30)
    private String itemCode;

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
