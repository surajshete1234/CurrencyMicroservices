package com.currency.microservices.currencyconversionservice.Executor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.currency.microservices.currencyconversionservice.DataModel.CurrencyConversion;
import com.currency.microservices.currencyconversionservice.Repository.CurrencyConversionProxy;

@Component
public class CurrencyConvertorExecutor {
	
	@Autowired
	private CurrencyConversionProxy proxy;

	public CurrencyConversion convertCurrency(String from, String to, BigDecimal quantity) {

		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseBody = 
				new RestTemplate().exchange("http://localhost:8000/CurrencyExchange/findByFromAndTo/{from}/{to}", HttpMethod.GET, null, CurrencyConversion.class,
						uriVariable);
		CurrencyConversion response = responseBody.getBody();
		return new CurrencyConversion(response.getId(), from, to, response.getConversion(), quantity,
				quantity.multiply(response.getConversion()), response.getPort());
	}
	
	public CurrencyConversion convertCurrencyfeign(String from, String to, BigDecimal quantity) {
		CurrencyConversion response = proxy.findByFromAndTo(from, to);
		return new CurrencyConversion(response.getId(), from, to, response.getConversion(), quantity,
				quantity.multiply(response.getConversion()), response.getPort());
	}

}
