package com.iyzico.challenge.mapper;

import com.iyzico.challenge.configuration.BaseMapperConfig;
import com.iyzico.challenge.entity.FlightEntity;
import com.iyzico.challenge.model.dto.FlightDto;
import com.iyzico.challenge.model.request.FlightRequest;
import com.iyzico.challenge.model.response.FlightResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(config = BaseMapperConfig.class)
public abstract class FlightMapper {

    public static final FlightMapper INSTANCE= Mappers.getMapper(FlightMapper.class);
    public abstract FlightEntity mapEntityByFlight(FlightDto flightDto);
    public abstract List<FlightEntity> mapEntityByFlight(List<FlightDto> flightDto);
    public abstract FlightDto mapDtoByFlight(FlightEntity flightEntity);
    public abstract List<FlightDto> mapDtoByFlight(List<FlightEntity> flightEntity);

    public abstract FlightDto mapDtoByRequest(FlightRequest flightRequest);
    public abstract List<FlightDto> mapDtoByRequest(List<FlightRequest> flightRequest);
    public abstract FlightResponse mapResponseByDto(FlightDto flightDto);
    public abstract List<FlightResponse> mapResponseByDto(List<FlightDto> flightDto);

    public abstract FlightRequest mapRequestByDto(FlightDto flightDto);
    public abstract List<FlightRequest> mapRequestByDto(List<FlightDto> flightDto);

}
