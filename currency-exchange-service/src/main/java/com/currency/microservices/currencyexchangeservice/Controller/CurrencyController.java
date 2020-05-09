package com.currency.microservices.currencyexchangeservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.currency.microservices.currencyexchangeservice.DataModel.ExchangeValue;
import com.currency.microservices.currencyexchangeservice.Executor.CurrencyExecutor;

@RestController
@RequestMapping("CurrencyExchange")
public class CurrencyController {

	@Autowired
	private CurrencyExecutor currenExec;

	@RequestMapping(value = "/from/{from}/to/{to}", method = RequestMethod.GET)
	public ResponseEntity<List<ExchangeValue>> retriveValue() {
		return new ResponseEntity<List<ExchangeValue>>(currenExec.retriveValue(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/findByFromAndTo/{from}/{to}" , method = RequestMethod.GET)
	public ExchangeValue findByFromAndTo(@PathVariable String from,@PathVariable String to){
		return currenExec.findByFromAndTO(from, to);
	}
}
