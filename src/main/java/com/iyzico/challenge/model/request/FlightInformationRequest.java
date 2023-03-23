package com.iyzico.challenge.model.request;

import com.iyzico.challenge.constant.FullType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightInformationRequest implements Serializable {

    private Integer flightId;
    private FullType status;
}
