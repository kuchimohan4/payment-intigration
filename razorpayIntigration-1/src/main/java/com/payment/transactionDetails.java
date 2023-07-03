package com.payment;

public class transactionDetails {
	
	private String orderId;
	private String currency;
	private String amount;
	private String key;
	
	public transactionDetails(String orderId, String currency, String amount, String key) {
		super();
		this.orderId = orderId;
		this.currency = currency;
		this.amount = amount;
		this.key = key;
	}
	public transactionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
	

}
