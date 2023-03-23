package com.iyzico.challenge.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceDto {

    private Integer id;
    private Date createdDate;
    private String createdUser;
    private Date updateDate;

    private String updateUser;

    private Boolean deleted;
    private Integer flightId;
    private Integer seatTypeId;
    private BigDecimal price;
}
