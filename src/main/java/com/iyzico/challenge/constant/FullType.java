package com.iyzico.challenge.constant;

import lombok.Getter;

@Getter
public enum FullType {
    FULL("FULL",1),HALF("HALF",2);

    private String desc;
    private Integer code;
    private FullType(String desc, Integer code){
        this.desc = desc;
        this.code = code;
    }
}
