package com.currency.microservices.currencyexchangeservice.DataModel;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CurrencyExchange")
public class ExchangeValue {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "currency_from")
	private String from; 
	
	@Column(name = "currency_to")
	private String to; 
	
	private BigDecimal conversion;
	
	private int port;

	private ExchangeValue() {
	}

	public ExchangeValue(Long id, String from, String to, BigDecimal conversion) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversion = conversion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversion() {
		return conversion;
	}

	public void setConversion(BigDecimal conversion) {
		this.conversion = conversion;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
