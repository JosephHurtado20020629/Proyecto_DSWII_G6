package com.cibertec.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "tb_currency_exchange")
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double buy;

    private Double sell;

    private String date;

    public CurrencyExchange(Double buy, Double sell, String date) {
        this.buy = buy;
        this.sell = sell;
        this.date = date;
    }


    public CurrencyExchange() {

    }
}
