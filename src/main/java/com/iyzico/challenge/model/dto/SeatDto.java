package com.iyzico.challenge.model.dto;

import com.iyzico.challenge.constant.CurrencyType;
import com.iyzico.challenge.constant.FullType;
import com.iyzico.challenge.constant.SeatType;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatDto {
    private Integer id;
    private Date createdDate;
    private String createdUser;
    private Date updateDate;

    private String updateUser;

    private Boolean deleted;

    private Integer flight;
    private Integer seatNum;
    private BigDecimal price;
    private SeatType seatType;
    private FullType status;
    private String desc;

    private CurrencyType currency;
}
