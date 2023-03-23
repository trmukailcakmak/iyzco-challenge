package com.iyzico.challenge.model.dto;

import com.iyzico.challenge.constant.FullType;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightDto {

    private Integer id;
    private Date createdDate;
    private String createdUser;
    private Date updateDate;

    private String updateUser;

    private Boolean deleted;
    private String name;
    private String desc;
    private String pnr;

    private FullType status;

}
