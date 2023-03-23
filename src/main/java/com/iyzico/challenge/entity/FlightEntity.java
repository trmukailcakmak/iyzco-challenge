package com.iyzico.challenge.entity;

import com.iyzico.challenge.constant.FullType;
import com.iyzico.challenge.entity.converter.FullTypeConverter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "FLIGHT")
public class FlightEntity extends BaseEntity {
    @Column(name = "NAME")
    private String name;
    @Column(name = "PNR")
    private String pnr;

    @Column(name = "DESC")
    private String desc;

    @Convert(converter = FullTypeConverter.class)
    private FullType status;

    @OneToMany(mappedBy = "flight",fetch = FetchType.EAGER)
    List<SeatEntity> seatList;
}
