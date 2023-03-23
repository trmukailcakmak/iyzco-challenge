package com.iyzico.challenge.mapper;

import com.iyzico.challenge.configuration.BaseMapperConfig;
import com.iyzico.challenge.entity.SeatEntity;
import com.iyzico.challenge.model.dto.SeatDto;
import com.iyzico.challenge.model.request.SeatRequest;
import com.iyzico.challenge.model.response.SeatResponse;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(config = BaseMapperConfig.class)
public abstract class SeatMapper {
    public static final SeatMapper INSTANCE= Mappers.getMapper(SeatMapper.class);

    @Mapping(source = "price",target = "price.amount")
    @Mapping(source = "flight",target = "flight.id")
    @Mapping(source = "currency",target = "price.currency")
    public abstract SeatEntity mapEntityBySeat(SeatDto seatDto);


    public abstract List<SeatEntity> mapEntityBySeat(List<SeatDto> seatDto);

    @Mapping(source = "seatType.seatType",target = "seatType")
    @Mapping(source = "price.amount",target = "price")
    @Mapping(source = "price.currency",target = "currency")
    @Mapping(source = "flight.id",target = "flight")
    public abstract SeatDto mapDtoBySeat(SeatEntity seatEntity);

    public abstract List<SeatDto> mapDtoBySeat(List<SeatEntity> seatEntity);

    public abstract SeatDto mapDtoByRequest(SeatRequest seatRequest);
    public abstract List<SeatDto> mapDtoByRequest(List<SeatRequest> seatRequest);
    public abstract SeatResponse mapResponseByDto(SeatDto seatDto);
    public abstract List<SeatResponse> mapResponseByDto(List<SeatDto> seatDto);

    public abstract SeatRequest mapRequestByDto(SeatDto seatDto);
    public abstract List<SeatRequest> mapRequestByDto(List<SeatDto> seatDto);

}
