package com.iyzico.challenge.constant;

public enum CurrencyType {
    DOLAR("$"),TL("TL"),EURO("EU");

    private String symbol;

    private CurrencyType(String symbol){
        this.symbol = symbol;
    }
}
