package com.cibertec.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cibertec.Models.CurrencyExchange;
import com.cibertec.Repositories.CurrencyExchangeRepository;
import com.cibertec.Services.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @Override
    public Integer save(CurrencyExchange currencyExchange) {
        return currencyExchangeRepository.save(currencyExchange).getId();
    }
}
