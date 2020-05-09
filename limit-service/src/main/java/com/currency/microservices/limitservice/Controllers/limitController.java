package com.currency.microservices.limitservice.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.currency.microservices.limitservice.DataModels.Book;
import com.currency.microservices.limitservice.Executor.LimitExecutor;

@RestController
@RequestMapping("/limit")
public class limitController {

	@Autowired
	private LimitExecutor limExec;

	@RequestMapping(value = "/getBookAmt", method = RequestMethod.GET)
	public ResponseEntity<Book> getTicket() {
		return new ResponseEntity<Book>(limExec.fetchAll(), HttpStatus.OK);
	}

}
