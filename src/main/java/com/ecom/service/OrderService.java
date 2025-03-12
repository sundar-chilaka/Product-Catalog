package com.ecom.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecom.model.OrderRequest;

@Service
public class OrderService {

	public String placeOrder(OrderRequest orderRequest) {
		String orderId = UUID.randomUUID().toString();
		return "Order placed successfully. Order ID: " + orderId;
	}
}
