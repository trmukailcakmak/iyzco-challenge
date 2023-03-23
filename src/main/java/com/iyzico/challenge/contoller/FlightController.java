package com.iyzico.challenge.contoller;

import com.iyzico.challenge.constant.EndPointConstant;
import com.iyzico.challenge.constant.MessageKey;
import com.iyzico.challenge.exception.IyzicoException;
import com.iyzico.challenge.mapper.FlightMapper;
import com.iyzico.challenge.model.dto.FlightDto;
import com.iyzico.challenge.model.request.FlightInformationRequest;
import com.iyzico.challenge.model.request.FlightRequest;
import com.iyzico.challenge.model.response.FlightInformationResponse;
import com.iyzico.challenge.model.response.FlightResponse;
import com.iyzico.challenge.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value=EndPointConstant.FLIGHT_PREFIX,produces={MediaType.APPLICATION_JSON_VALUE})
public class FlightController {

    private Logger logger = LoggerFactory.getLogger(FlightController.class);
    private final FlightMapper flightMapper = FlightMapper.INSTANCE;
    private final MessageSource messageSource;
    private final FlightService flightService;

    public FlightController(MessageSource messageSource, FlightService flightService) {
        this.messageSource = messageSource;
        this.flightService = flightService;
    }

    @PostMapping(value = EndPointConstant.ADD)
    public @ResponseBody ResponseEntity<FlightResponse>   addFlight(@RequestBody @Valid FlightRequest flightRequest){
            FlightDto flightDto = flightService.addAndUpdateFlight(flightMapper.mapDtoByRequest(flightRequest));
            return new ResponseEntity<>(flightMapper.mapResponseByDto(flightDto), HttpStatus.OK);
    }

    @PutMapping(value=EndPointConstant.UPDATE)
    public @ResponseBody ResponseEntity<FlightResponse>   updateFlight(@RequestBody @Valid FlightRequest flightRequest){
        FlightDto flightDto = flightService.addAndUpdateFlight(flightMapper.mapDtoByRequest(flightRequest));
        return new ResponseEntity<>(flightMapper.mapResponseByDto(flightDto), HttpStatus.OK);
    }

    @DeleteMapping(value=EndPointConstant.DELETE)
    public @ResponseBody ResponseEntity<String>   deleteFlight(@PathVariable("deleteId") Integer deleteId){
        flightService.deleteFlight(deleteId);
        return new ResponseEntity<>(this.messageSource.getMessage(MessageKey.INFO01,null, Locale.ENGLISH), HttpStatus.OK);
    }

    @PostMapping(value = EndPointConstant.FLIGHT_INFORMATION)
    public @ResponseBody ResponseEntity<List<FlightInformationResponse>>   getFlightInformation(@Valid @RequestBody FlightInformationRequest flightInformationRequest){
        List<FlightInformationResponse> flightInformationResponseList = flightService.getFlightInformation(flightInformationRequest.getFlightId(),flightInformationRequest.getStatus());
        return new ResponseEntity<>(flightInformationResponseList, HttpStatus.OK);
    }
}
