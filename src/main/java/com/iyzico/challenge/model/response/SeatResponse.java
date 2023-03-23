package com.iyzico.challenge.model.response;

import com.iyzico.challenge.constant.FullType;
import com.iyzico.challenge.constant.SeatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatResponse implements Serializable {
    private Integer id;
    private Date createdDate;
    private String createdUser;
    private Date updateDate;

    private String updateUser;

    private Boolean deleted;

    private Integer flightId;
    private Integer seatNum;
    private BigDecimal price;
    private SeatType seatType;
    private FullType status;
    private String desc;
}
