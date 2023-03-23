package com.iyzico.challenge;

import com.iyzico.challenge.constant.FullType;
import com.iyzico.challenge.constant.SeatType;
import com.iyzico.challenge.entity.FlightEntity;
import com.iyzico.challenge.entity.PriceEntity;
import com.iyzico.challenge.entity.SeatEntity;
import com.iyzico.challenge.entity.SeatTypeEntity;
import com.iyzico.challenge.model.dto.FlightDto;
import com.iyzico.challenge.model.dto.SeatDto;
import com.iyzico.challenge.model.request.FlightRequest;
import com.iyzico.challenge.model.request.SeatRequest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class TestDataPool {

    public static FlightRequest createFlightRequest(){
        FlightRequest flightRequest = new FlightRequest();
        flightRequest.setId(Integer.valueOf(1));
        flightRequest.setName("test-name");
        flightRequest.setDesc("test-desc");
        flightRequest.setPnr("test-pnr");
        flightRequest.setStatus(FullType.HALF);
        return flightRequest;
    }

    public static FlightDto createFlightDto(){
        FlightDto flightDto = new FlightDto();
        flightDto.setId(1);
        flightDto.setName("test-name");
        flightDto.setDesc("test-desc");
        flightDto.setPnr("test-pnr");
        return flightDto;
    }

    public static FlightEntity createFlightEntity(){
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setStatus(FullType.HALF);
        flightEntity.setPnr("test-pnr");
        flightEntity.setName("test-name");
        flightEntity.setSeatList(Arrays.asList(createSeatEntity()));
        return flightEntity;
    }

    public static SeatRequest createSeatRequest(){
        SeatRequest seatRequest = new SeatRequest();
        seatRequest.setId(Integer.valueOf(1));
        seatRequest.setFlight(Integer.valueOf(1));
        seatRequest.setSeatNum(Integer.valueOf(1));
        seatRequest.setDesc("test-desc");
        seatRequest.setPrice(BigDecimal.valueOf(12.00));
        seatRequest.setSeatType(SeatType.EKO);
        seatRequest.setStatus(FullType.HALF);
        return seatRequest;
    }

    public static SeatDto createSeatDto(){
        SeatDto seatDto = new SeatDto();
        seatDto.setId(1);
        seatDto.setDesc("test-name");
        seatDto.setDesc("test-desc");
        seatDto.setSeatNum(12);
        return seatDto;
    }

    public static SeatEntity createSeatEntity(){
        SeatEntity seatEntity = new SeatEntity();
        seatEntity.setId(1);
        seatEntity.setSeatNum(1);
        seatEntity.setSeatType(createSeatTypeEntity());
        seatEntity.setPrice(createPriceEntity());
        return seatEntity;
    }

    public static SeatTypeEntity createSeatTypeEntity(){
        SeatTypeEntity seatTypeEntity = new SeatTypeEntity();
        seatTypeEntity.setId(1);
        seatTypeEntity.setSeatType(SeatType.EKO);
        seatTypeEntity.setCreatedDate(new Date());
        seatTypeEntity.setCreatedUser("test-create-user");
        return seatTypeEntity;
    }

    public static PriceEntity createPriceEntity(){
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setAmount(BigDecimal.ONE);
        priceEntity.setId(1);
        priceEntity.setCreatedDate(new Date());
        priceEntity.setCreatedUser("test-create-user");
        return priceEntity;
    }
}
