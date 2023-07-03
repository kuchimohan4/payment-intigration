package com.payment.service;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.payment.transactionDetails;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Component
public class paymentService {
	
	private static final String SECRET_ID = "rzp_test_snvXEPmPJNCZ3U";
	private static final String SECRET_KEY = "xSexxVJlCuQxC4L0DcvT9LAX";
	private static final String CURRENCY="INR";
	
	public transactionDetails createOrder(double amount) throws RazorpayException {
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("amount", amount);
		jsonObject.put("currency", CURRENCY);
		
		
		RazorpayClient razorpayClient=new RazorpayClient(SECRET_ID, SECRET_KEY);
		
		 Order order= razorpayClient.orders.create(jsonObject);
		 
		 
//		System.out.println(order);
		return genrateTranscationDetails(order);
		
		
	}
	
	public transactionDetails genrateTranscationDetails(Order order) {
		
		String orderid=order.get("id");
		String currency=order.get("currency");
		String amount=order.get("amount").toString(); 
		return new transactionDetails(orderid, currency, amount,SECRET_KEY);
	}

	

}
