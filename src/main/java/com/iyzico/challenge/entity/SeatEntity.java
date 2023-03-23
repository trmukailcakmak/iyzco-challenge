package com.iyzico.challenge.entity;

import com.iyzico.challenge.constant.FullType;
import com.iyzico.challenge.entity.converter.FullTypeConverter;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SEAT")
public class SeatEntity extends BaseEntity {

    @ManyToOne
    private FlightEntity flight;
    private Integer seatNum;
    @OneToOne(cascade=CascadeType.ALL)
    private PriceEntity price;
    @OneToOne(cascade=CascadeType.ALL)
    private SeatTypeEntity seatType;
    @Convert(converter = FullTypeConverter.class)
    private FullType status;
    private String desc;



}
