package com.iyzico.challenge.model.request;

import com.iyzico.challenge.constant.CurrencyType;
import com.iyzico.challenge.constant.FullType;
import com.iyzico.challenge.constant.MessageKey;
import com.iyzico.challenge.constant.SeatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequest implements Serializable {

    private static final long serialVersionUID = 6986081670586149759L;
    private Integer id;
    private Integer flight;
    private Integer seatNum;
    private BigDecimal price;
    private CurrencyType currency;

    @NotNull(message = MessageKey.ERR13)
    private SeatType seatType;
    @NotNull(message = MessageKey.ERR12)
    private FullType status;
    private String desc;
}
