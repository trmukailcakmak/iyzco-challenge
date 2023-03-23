package com.iyzico.challenge.entity;

import com.iyzico.challenge.constant.CurrencyType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "PRICE")
public class PriceEntity extends BaseEntity{
    private BigDecimal amount;
    private CurrencyType currency;
}
