package com.iyzico.challenge.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightResponse implements Serializable {
    private static final long serialVersionUID = 6438744056124161977L;
    private Integer id;
    private Date createdDate;
    private String createdUser;
    private Date updateDate;

    private String updateUser;

    private Boolean deleted;
    private String name;
    private String desc;

    private String pnr;
}
