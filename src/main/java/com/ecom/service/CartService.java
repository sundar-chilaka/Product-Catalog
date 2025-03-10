package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.CartItem;
import com.ecom.entity.Product;
import com.ecom.repository.CartItemRepository;
import com.ecom.repository.ProductRepository;

@Service
public class CartService {

	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private ProductRepository productRepository;

	public List<CartItem> getCartItems() {
		return cartItemRepository.findAll();
	}

	public void removeFromCart(Long cartItemId) {
		cartItemRepository.deleteById(cartItemId);
	}

	public CartItem addToCart(Long prodectId, int quantity) {
		Product product = productRepository.findById(prodectId)
				.orElseThrow(() -> new RuntimeException("Product not found"));

		CartItem cart = new CartItem();
		cart.setProduct(product);
		cart.setQuantity(quantity);
		return cartItemRepository.save(cart);

	}
}
