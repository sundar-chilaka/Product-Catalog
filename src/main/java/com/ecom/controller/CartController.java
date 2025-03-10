package com.ecom.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.CartItem;
import com.ecom.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	private final CartService cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping
	public List<CartItem> getCartItems() {
		return cartService.getCartItems();
	}

	@PostMapping("/add")
	public CartItem addToCart(@RequestParam Long productId, @RequestParam int quantity) {
		return cartService.addToCart(productId, quantity);
	}

	@DeleteMapping("/remove/{id}")
	public void removeFromCart(@PathVariable Long id) {
		cartService.removeFromCart(id);
	}
}
