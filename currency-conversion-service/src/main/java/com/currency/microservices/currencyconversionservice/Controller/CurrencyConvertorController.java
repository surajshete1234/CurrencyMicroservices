package com.currency.microservices.currencyconversionservice.Controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currency.microservices.currencyconversionservice.DataModel.CurrencyConversion;
import com.currency.microservices.currencyconversionservice.Executor.CurrencyConvertorExecutor;

@RestController
@RequestMapping("/Currconvertor")
public class CurrencyConvertorController {
	
	@Autowired
	private CurrencyConvertorExecutor currencyConvExec;
	
	@RequestMapping(value="/convertCurrency/{from}/{to}/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity) {
		return currencyConvExec.convertCurrency(from,to,quantity);
	}
	
	@RequestMapping(value="/convertCurrencyfeign/{from}/{to}/{quantity}")
	public CurrencyConversion convertCurrencyfeign(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity) {
		return currencyConvExec.convertCurrencyfeign(from,to,quantity);
	}

}
