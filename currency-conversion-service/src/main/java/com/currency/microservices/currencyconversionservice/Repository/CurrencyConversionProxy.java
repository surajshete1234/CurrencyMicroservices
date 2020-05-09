package com.currency.microservices.currencyconversionservice.Repository;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.currency.microservices.currencyconversionservice.DataModel.CurrencyConversion;

//@FeignClient(name="currency-exchange-service",url="localhost:8000")
@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyConversionProxy {

	
	@RequestMapping(value="/CurrencyExchange/findByFromAndTo/{from}/{to}" , method = RequestMethod.GET)
	public CurrencyConversion findByFromAndTo(@PathVariable ("from") String from,@PathVariable ("to") String to);
}
