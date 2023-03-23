package com.iyzico.challenge.entity.converter;

import com.iyzico.challenge.constant.SeatType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


public class SeatTypeConverterTest {

    @InjectMocks
    private SeatTypeConverter seatTypeConverter;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void convertToDatabaseColumn() {
        Assert.assertEquals(SeatType.EKO.name(),seatTypeConverter.convertToDatabaseColumn(SeatType.EKO));
    }

    @Test
    public void convertToEntityAttribute() {
        Assert.assertEquals(SeatType.EKO,seatTypeConverter.convertToEntityAttribute(SeatType.EKO.name()));
    }
}