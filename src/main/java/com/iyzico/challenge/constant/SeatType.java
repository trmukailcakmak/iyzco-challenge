package com.iyzico.challenge.constant;

import lombok.Getter;

@Getter
public enum SeatType {
    EKO("EKO",1),BUSINESS("BUSINESS",2);

    private String desc;
    private Integer code;

    private SeatType(String desc,Integer code){
        this.desc = desc;
        this.code = code;
    }
}
