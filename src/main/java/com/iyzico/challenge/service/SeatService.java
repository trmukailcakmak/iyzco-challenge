package com.iyzico.challenge.service;

import com.iyzico.challenge.constant.MessageKey;
import com.iyzico.challenge.entity.FlightEntity;
import com.iyzico.challenge.entity.SeatEntity;
import com.iyzico.challenge.exception.IyzicoException;
import com.iyzico.challenge.mapper.SeatMapper;
import com.iyzico.challenge.model.dto.SeatDto;
import com.iyzico.challenge.repository.FlightRepository;
import com.iyzico.challenge.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatService {
    private Logger logger = LoggerFactory.getLogger(SeatService.class);
    private final SeatMapper seatMapper= SeatMapper.INSTANCE;
    private final SeatRepository seatRepository;
    private final FlightRepository flightRepository;

    public SeatDto addAndUpdateSeat(SeatDto seatDto){

            Optional<FlightEntity> flightEntityOptional = flightRepository.findById(seatDto.getFlight());

            if(!flightEntityOptional.isPresent()){
                throw new IyzicoException(MessageKey.ERR11);
            }

            if(seatDto.getId()==null) {
                Optional<SeatEntity> seatEntityOptional = seatRepository.findByFlight_IdEqualsAndSeatNumEquals(seatDto.getFlight(), seatDto.getSeatNum());

                if (seatEntityOptional.isPresent()) {
                    throw new IyzicoException(MessageKey.ERRO4);
                }
            }else{
                logger.debug(seatDto.getId()+" no lu koltuk bilgileri guncellenecektir.");
            }

            SeatEntity entity = seatMapper.mapEntityBySeat(seatDto);
            Optional<FlightEntity> flightEntityOpt = flightRepository.findById(seatDto.getFlight());
            if(flightEntityOpt.isPresent()) {
                entity.setFlight(flightEntityOpt.get());
            }
            entity = seatRepository.save(entity);
            logger.debug(entity.getId()+" no lu seat eklendi.");
            return seatMapper.mapDtoBySeat(entity);
    }

    public Boolean deleteSeat(Integer seatId){
            seatRepository.deleteById(seatId);
            logger.debug(seatId+" no lu seat silindi.");
            return true;
    }
}
