package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.model.PaymentRequest;

@Service
public class PaymentService {

	public String initiateCheckout(PaymentRequest paymentRequest) {
		return "Checkout initialized for amount: " + paymentRequest.getAmount();
	}

	public String processPayment(PaymentRequest paymentRequest) {
		return "Payment processed successfully for amount: " + paymentRequest.getAmount();
	}
}
