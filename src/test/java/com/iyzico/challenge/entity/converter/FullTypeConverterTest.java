package com.iyzico.challenge.entity.converter;

import com.iyzico.challenge.constant.FullType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class FullTypeConverterTest {

    @InjectMocks
    private FullTypeConverter fullTypeConverter;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void convertToDatabaseColumn() {
        Assert.assertEquals(FullType.FULL.name(),this.fullTypeConverter.convertToDatabaseColumn(FullType.FULL));
    }

    @Test
    public void convertToEntityAttribute() {
        Assert.assertEquals(FullType.FULL,this.fullTypeConverter.convertToEntityAttribute(FullType.FULL.name()));
    }
}