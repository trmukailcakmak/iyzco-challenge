package com.iyzico.challenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatTypeDto {
    private Integer id;
    private Date createdDate;
    private String createdUser;
    private Date updateDate;

    private String updateUser;

    private Boolean deleted;
}
