package com.cibertec.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cibertec.Models.CurrencyExchange;
import com.cibertec.Repositories.CurrencyExchangeRepository;
import com.cibertec.Services.CurrencyExchangeService;

import java.util.List;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @Override
    public Integer save(CurrencyExchange currencyExchange) {
        return currencyExchangeRepository.save(currencyExchange).getId();
    }

    @Override
    public CurrencyExchange findTheCurrent() {
        return currencyExchangeRepository.findTop1ByOrderByDateDesc();
    }

    @Override
    public List<CurrencyExchange> findAllByOrderByDateAsc() {
        return currencyExchangeRepository.findAllByOrderByDateAsc();
    }
}
