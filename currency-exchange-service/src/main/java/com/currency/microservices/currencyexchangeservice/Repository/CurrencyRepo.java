package com.currency.microservices.currencyexchangeservice.Repository;

import org.springframework.data.repository.CrudRepository;

import com.currency.microservices.currencyexchangeservice.DataModel.ExchangeValue;

public interface CurrencyRepo extends CrudRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from,String to);

}
