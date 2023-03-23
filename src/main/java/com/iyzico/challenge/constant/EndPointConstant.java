package com.iyzico.challenge.constant;

import org.springframework.stereotype.Component;

@Component
public class EndPointConstant {
    public static final String FLIGHT_PREFIX = "/flight";
    public static final String SEAT_PREFIX = "/seat";
    public static final String ADD = "/add";
    public static final String UPDATE = "/update";

    public static final String FLIGHT_INFORMATION="/flight-information";
    public static final String DELETE = "/delete/{deleteId}";
}
