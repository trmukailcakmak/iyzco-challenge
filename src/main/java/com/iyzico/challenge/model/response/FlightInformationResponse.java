package com.iyzico.challenge.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightInformationResponse implements Serializable {
    private static final long serialVersionUID = 6767606830375252601L;
    private String flightName;
    private Integer seatNum;
    private BigDecimal price;
    private String seatTypeName;
}
