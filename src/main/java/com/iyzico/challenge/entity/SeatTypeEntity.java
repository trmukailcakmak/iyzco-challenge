package com.iyzico.challenge.entity;

import com.iyzico.challenge.constant.SeatType;
import com.iyzico.challenge.entity.converter.SeatTypeConverter;
import com.iyzico.challenge.repository.SeatTypeRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "SEAT_TYPE")
public class SeatTypeEntity extends BaseEntity{

    @Convert(converter = SeatTypeConverter.class)
    private SeatType seatType;
}
