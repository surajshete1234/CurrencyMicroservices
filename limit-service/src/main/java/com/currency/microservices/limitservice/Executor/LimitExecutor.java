package com.currency.microservices.limitservice.Executor;

import org.springframework.stereotype.Component;

import com.currency.microservices.limitservice.DataModels.Book;

@Component
public class LimitExecutor {

	public Book fetchAll() {
		Book bk = new Book(800,200);
		return bk;
	}

}
