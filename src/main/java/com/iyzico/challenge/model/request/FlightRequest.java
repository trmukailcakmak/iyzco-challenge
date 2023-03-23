package com.iyzico.challenge.model.request;

import com.iyzico.challenge.constant.FullType;
import com.iyzico.challenge.constant.MessageKey;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightRequest implements Serializable {
    private static final long serialVersionUID = 5777927055474136377L;
    private Integer id;

    private String name;
    private String desc;

    private String pnr;
    @NotNull(message = MessageKey.ERR12)
    private FullType status;
}
