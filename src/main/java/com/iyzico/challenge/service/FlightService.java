package com.iyzico.challenge.service;

import com.iyzico.challenge.constant.FullType;
import com.iyzico.challenge.constant.MessageKey;
import com.iyzico.challenge.entity.FlightEntity;
import com.iyzico.challenge.entity.SeatEntity;
import com.iyzico.challenge.exception.IyzicoException;
import com.iyzico.challenge.mapper.FlightMapper;
import com.iyzico.challenge.model.dto.FlightDto;
import com.iyzico.challenge.model.response.FlightInformationResponse;
import com.iyzico.challenge.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private Logger logger = LoggerFactory.getLogger(FlightService.class);
    private final FlightMapper flightMapper=FlightMapper.INSTANCE;
    private final FlightRepository flightRepository;
    private final MessageSource messageSource;

    public FlightService(FlightRepository flightRepository, MessageSource messageSource) {
        this.flightRepository = flightRepository;
        this.messageSource = messageSource;
    }

    public List<FlightInformationResponse> getFlightInformation(Integer flightId,FullType filterFullType){

        List<FlightEntity> flightAll =new ArrayList<>();

        if(Objects.nonNull(flightId)){
            Optional<FlightEntity> flightEntityOptional = this.flightRepository.findById(flightId);
            if(flightEntityOptional.isPresent()){
                flightAll = Arrays.asList(flightEntityOptional.get());
            }
        } else {
            logger.debug("tum ucuslar listelenecek...");
            flightAll = this.flightRepository.findAll();
        }

        List<FlightInformationResponse> flightInformationResponseList =new ArrayList<>();

        flightAll.forEach(flight ->{

            List<SeatEntity> seatList = flight.getSeatList().stream().filter(seat -> FullType.HALF.equals(filterFullType)).collect(Collectors.toList());

            seatList.forEach(seat ->{
                FlightInformationResponse flightInformationResponse = new FlightInformationResponse();
                flightInformationResponse.setFlightName(flight.getName());
                flightInformationResponse.setSeatNum(seat.getSeatNum());
                flightInformationResponse.setPrice(seat.getPrice().getAmount());
                flightInformationResponse.setSeatTypeName(seat.getSeatType().getSeatType().getDesc());
                flightInformationResponseList.add(flightInformationResponse);
            });
        });

        if(flightInformationResponseList.isEmpty()){
            if(FullType.HALF.equals(filterFullType))
                throw new IyzicoException(MessageKey.GENERAL_ERR,MessageKey.ERR02,this.messageSource.getMessage(MessageKey.ERR02,null, Locale.ENGLISH));

            if(FullType.FULL.equals(filterFullType))
                throw new IyzicoException(MessageKey.GENERAL_ERR,MessageKey.ERR03,this.messageSource.getMessage(MessageKey.ERR03,null, Locale.ENGLISH));


        }

        return flightInformationResponseList;

    }

    public FlightDto addAndUpdateFlight(FlightDto flightDto){
            FlightEntity entity = flightMapper.mapEntityByFlight(flightDto);
            entity = flightRepository.save(entity);
            logger.debug(entity.getId()+" no lu flight eklendi.");
            return flightMapper.mapDtoByFlight(entity);
    }

    public Boolean deleteFlight(Integer flightId){
           flightRepository.deleteById(flightId);
           logger.debug(flightId+" no lu flight silindi.");
           return true;
    }
}
