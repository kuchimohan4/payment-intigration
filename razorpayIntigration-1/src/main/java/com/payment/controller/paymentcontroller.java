package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.payment.transactionDetails;
import com.payment.service.paymentService;
import com.razorpay.RazorpayException;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class paymentcontroller {
	
	@Autowired
	private paymentService paymentService;
	
	@GetMapping("/createOrder/{amount}")
	public transactionDetails createorder(@PathVariable double amount) throws RazorpayException {
		
	  return paymentService.createOrder(amount);	
		
		
	}
	

}
