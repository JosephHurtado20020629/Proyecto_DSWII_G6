package com.cibertec.Repositories;

import com.cibertec.Models.CurrencyExchange;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrencyExchangeRepository extends CrudRepository<CurrencyExchange, Integer> {

    CurrencyExchange  findTop1ByOrderByDateDesc();

    List<CurrencyExchange> findAllByOrderByDateAsc();
}
