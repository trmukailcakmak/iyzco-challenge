package com.iyzico.challenge.service;


import com.iyzico.challenge.TestDataPool;
import com.iyzico.challenge.entity.FlightEntity;
import com.iyzico.challenge.entity.SeatEntity;
import com.iyzico.challenge.exception.IyzicoException;
import com.iyzico.challenge.mapper.SeatMapper;
import com.iyzico.challenge.model.dto.SeatDto;
import com.iyzico.challenge.repository.FlightRepository;
import com.iyzico.challenge.repository.SeatRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;

import java.util.Optional;

public class SeatServiceTest {

    private final SeatMapper seatMapper = SeatMapper.INSTANCE;

    @InjectMocks
    private SeatService seatService;

    @Mock
    private SeatRepository seatRepository;

    @Mock
    private FlightRepository flightRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddAndUpdateSeat() {
        SeatDto seatDto = TestDataPool.createSeatDto();
        FlightEntity flightEntity = TestDataPool.createFlightEntity();
        Optional<FlightEntity> seatEntityOptional = Optional.of(flightEntity);
        Mockito.when(flightRepository.findById(Mockito.any())).thenReturn(seatEntityOptional);
        Mockito.when(seatRepository.save(Mockito.any())).thenReturn(seatMapper.mapEntityBySeat(seatDto));
        seatDto = seatService.addAndUpdateSeat(seatDto);
        Assert.assertNotNull(seatDto);
    }

    @Test(expected = IyzicoException.class)
    public void testAddAndUpdateSeatByIdNullable() {
        SeatDto seatDto = TestDataPool.createSeatDto();
        seatDto.setId(null);
        FlightEntity flightEntity = TestDataPool.createFlightEntity();
        Optional<FlightEntity> seatEntityOptional = Optional.of(flightEntity);
        Mockito.when(flightRepository.findById(Mockito.any())).thenReturn(seatEntityOptional);
        Mockito.when(seatRepository.findByFlight_IdEqualsAndSeatNumEquals(Mockito.any(),Mockito.any())).thenReturn(Optional.of(seatMapper.mapEntityBySeat(seatDto)));
        Mockito.when(seatRepository.save(Mockito.any())).thenReturn(seatMapper.mapEntityBySeat(seatDto));
        seatService.addAndUpdateSeat(seatDto);
    }

    @Test(expected = IyzicoException.class)
    public void testAddAndUpdateSeatAsIyzicoException() {
        SeatDto seatDto = TestDataPool.createSeatDto();
        seatDto.setId(1);
        Mockito.when(flightRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(seatRepository.save(Mockito.any())).thenThrow(new MockitoException("SeatAddOrUpdateExceptionDesc"));
        seatService.addAndUpdateSeat(seatDto);
    }

    @Test
    public void testDeleteSeat() {
        SeatDto seatDto = TestDataPool.createSeatDto();
        seatDto.setId(1);
        Mockito.doNothing().when(seatRepository).deleteById(Mockito.any());
        Boolean isReturn = seatService.deleteSeat(1);
        Assert.assertTrue(isReturn);
    }

}