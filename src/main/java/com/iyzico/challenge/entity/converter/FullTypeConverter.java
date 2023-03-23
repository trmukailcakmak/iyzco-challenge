package com.iyzico.challenge.entity.converter;

import com.iyzico.challenge.constant.FullType;

import javax.persistence.AttributeConverter;

public class FullTypeConverter implements AttributeConverter<FullType, String> {
    @Override
    public String convertToDatabaseColumn(FullType fullType) {
        return fullType.name();
    }

    @Override
    public FullType convertToEntityAttribute(String name) {
        return FullType.valueOf(name);
    }
}
