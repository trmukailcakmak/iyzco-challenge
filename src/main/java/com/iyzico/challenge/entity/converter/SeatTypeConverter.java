package com.iyzico.challenge.entity.converter;

import com.iyzico.challenge.constant.SeatType;

import javax.persistence.AttributeConverter;

public class SeatTypeConverter implements AttributeConverter<SeatType, String> {
    @Override
    public String convertToDatabaseColumn(SeatType seatType) {
        return seatType.name();
    }

    @Override
    public SeatType convertToEntityAttribute(String name) {
        return SeatType.valueOf(name);
    }
}
