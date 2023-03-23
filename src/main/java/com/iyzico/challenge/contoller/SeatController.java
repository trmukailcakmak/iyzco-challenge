package com.iyzico.challenge.contoller;

import com.iyzico.challenge.constant.EndPointConstant;
import com.iyzico.challenge.mapper.SeatMapper;
import com.iyzico.challenge.model.dto.SeatDto;
import com.iyzico.challenge.model.request.SeatRequest;
import com.iyzico.challenge.model.response.SeatResponse;
import com.iyzico.challenge.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value=EndPointConstant.SEAT_PREFIX,produces={MediaType.APPLICATION_JSON_VALUE})
public class SeatController {

    private Logger logger = LoggerFactory.getLogger(SeatController.class);
    private final SeatMapper seatMapper = SeatMapper.INSTANCE;
    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping(value = EndPointConstant.ADD)
    public @ResponseBody ResponseEntity<SeatResponse>   addSeat(@RequestBody @Valid SeatRequest seatRequest){
        SeatDto seatDto = seatService.addAndUpdateSeat(seatMapper.mapDtoByRequest(seatRequest));
        return new ResponseEntity<>(seatMapper.mapResponseByDto(seatDto), HttpStatus.OK);
    }

    @PutMapping(value=EndPointConstant.UPDATE)
    public @ResponseBody ResponseEntity<SeatResponse>   updateSeat(@RequestBody @Valid SeatRequest seatRequest){
        SeatDto seatDto = seatService.addAndUpdateSeat(seatMapper.mapDtoByRequest(seatRequest));
        return new ResponseEntity<>(seatMapper.mapResponseByDto(seatDto), HttpStatus.OK);
    }

    @DeleteMapping(value=EndPointConstant.DELETE)
    public @ResponseBody ResponseEntity<String>   deleteSeat(@PathVariable("deleteId") Integer deleteId){
        Boolean isDeleted = seatService.deleteSeat(deleteId);
        if(isDeleted) {
            return new ResponseEntity<>("Basarili bir sekilde silindi.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Silme islemi sirasinda bir hata alindi.",HttpStatus.OK);
        }
    }
}
