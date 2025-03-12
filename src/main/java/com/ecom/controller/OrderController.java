package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.OrderRequest;
import com.ecom.service.OrderService;

@RestController
@RequestMapping("/orders")
class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/place")
	public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
		String response = orderService.placeOrder(orderRequest);
		return ResponseEntity.ok(response);
	}
}