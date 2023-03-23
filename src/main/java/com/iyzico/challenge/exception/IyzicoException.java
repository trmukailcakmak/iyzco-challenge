package com.iyzico.challenge.exception;//package com.iyzico.challenge.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
@Setter
public class IyzicoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String code;
    private Object[] prmList;
    public IyzicoException(String code,String ... prmList){
        super();
        this.code = code;
        this.prmList = prmList;
    }

}
