package com.cibertec.Services;

import com.cibertec.Models.CurrencyExchange;

import java.util.List;

public interface CurrencyExchangeService {
    Integer save(CurrencyExchange currencyExchange);

    CurrencyExchange findTheCurrent();

   List<CurrencyExchange> findAllByOrderByDateAsc();
}
