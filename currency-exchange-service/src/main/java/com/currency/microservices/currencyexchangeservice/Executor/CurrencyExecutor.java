package com.currency.microservices.currencyexchangeservice.Executor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.currency.microservices.currencyexchangeservice.DataModel.ExchangeValue;
import com.currency.microservices.currencyexchangeservice.Repository.CurrencyRepo;

@Component
public class CurrencyExecutor {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyRepo curRepo;

	public List<ExchangeValue> retriveValue() {
		//List <ExchangeValue> exchanval=(List<ExchangeValue>) curRepo.findAll();
		//((ExchangeValue) exchanval).setPort(Integer.parseInt(env.getProperty("local.server.port")));	
		return (List<ExchangeValue>) curRepo.findAll();
	}
	
	public ExchangeValue findByFromAndTO(String from,String to) {
		ExchangeValue exchangval= curRepo.findByFromAndTo(from,to);	
		exchangval.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		System.out.println(exchangval.getFrom());
		System.out.println(exchangval.getTo());
		System.out.println(exchangval.getConversion());
		System.out.println(exchangval.getPort());
		return exchangval;
	}
	
	
}
