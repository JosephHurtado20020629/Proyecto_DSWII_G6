package com.cibertec.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_currency_exchange")
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date;

    private Double lastValue;

    private Double firstValue;

    private Double maxValue;

    private Double minValue;

    public CurrencyExchange(String date,Double lastValue,Double firstValue,Double maxValue,Double minValue){
        this.date= date;
        this.lastValue =lastValue;
        this.firstValue=firstValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public CurrencyExchange() {

    }
}
