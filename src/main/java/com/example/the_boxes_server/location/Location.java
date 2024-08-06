package com.example.the_boxes_server.location;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "location")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @Size(max = 14)
    private String dispatchCode;

    @NotNull
    private Date workDate;

    @Size(max = 20)
    @NotBlank
    private String workerId;

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
