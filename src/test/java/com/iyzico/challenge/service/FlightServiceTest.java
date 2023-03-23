package com.iyzico.challenge.service;


import com.iyzico.challenge.TestDataPool;
import com.iyzico.challenge.constant.FullType;
import com.iyzico.challenge.entity.FlightEntity;
import com.iyzico.challenge.exception.IyzicoException;
import com.iyzico.challenge.mapper.FlightMapper;
import com.iyzico.challenge.model.dto.FlightDto;
import com.iyzico.challenge.model.response.FlightInformationResponse;
import com.iyzico.challenge.repository.FlightRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.context.MessageSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightServiceTest {

    private final FlightMapper flightMapper = FlightMapper.INSTANCE;

    @InjectMocks
    private FlightService flightService;

    @Mock
    private FlightRepository flightRepository;
    @Mock
    private MessageSource messageSource;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetFlightInformation() {
        FlightEntity flightEntity = TestDataPool.createFlightEntity();
        List<FlightEntity> flightEntityList = new ArrayList<>();
        flightEntityList.add(flightEntity);
        Optional<FlightEntity> seatEntityOptional = Optional.of(flightEntity);
        Mockito.when(flightRepository.findById(Mockito.any())).thenReturn(seatEntityOptional);
        Mockito.when(messageSource.getMessage(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn("test-error-message-source");
        Mockito.when(flightRepository.findAll()).thenReturn(flightEntityList);
        List<FlightInformationResponse> flightInformationResponseList = flightService.getFlightInformation(Integer.valueOf(1),FullType.HALF);
        Assert.assertFalse(flightInformationResponseList.isEmpty());
    }

    @Test(expected = IyzicoException.class)
    public void testGetFlightInformationAsIyzicoExceptionErr02() {
        FlightEntity flightEntity = TestDataPool.createFlightEntity();
        List<FlightEntity> flightEntityList = new ArrayList<>();
        Optional<FlightEntity> seatEntityOptional = Optional.of(flightEntity);
        Mockito.when(flightRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(messageSource.getMessage(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn("test-error-message-source");
        Mockito.when(flightRepository.findAll()).thenReturn(flightEntityList);
        List<FlightInformationResponse> flightInformationResponseList = flightService.getFlightInformation(Integer.valueOf(1),FullType.HALF);
    }

    @Test(expected = IyzicoException.class)
    public void testGetFlightInformationAsIyzicoExceptionErr03() {
        FlightEntity flightEntity = TestDataPool.createFlightEntity();
        List<FlightEntity> flightEntityList = new ArrayList<>();
        flightEntityList.add(flightEntity);
        Optional<FlightEntity> seatEntityOptional = Optional.of(flightEntity);
        Mockito.when(flightRepository.findById(Mockito.any())).thenReturn(seatEntityOptional);
        Mockito.when(messageSource.getMessage(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn("test-error-message-source");
        Mockito.when(flightRepository.findAll()).thenReturn(flightEntityList);
        List<FlightInformationResponse> flightInformationResponseList = flightService.getFlightInformation(Integer.valueOf(1),FullType.FULL);
    }

    @Test
    public void testAddAndUpdateFlight() {
        FlightDto flightDto = TestDataPool.createFlightDto();
        flightDto.setId(1);
        Mockito.when(flightRepository.save(Mockito.any())).thenReturn(flightMapper.mapEntityByFlight(flightDto));
        flightDto = flightService.addAndUpdateFlight(flightDto);
        Assert.assertNotNull(flightDto);
    }

    @Test
    public void testDeleteFlight() {
        FlightDto flightDto = TestDataPool.createFlightDto();
        flightDto.setId(1);
        Mockito.doNothing().when(flightRepository).deleteById(Mockito.any());
        Boolean isReturn = flightService.deleteFlight(1);
        Assert.assertTrue(isReturn);
    }

}