package com.ecom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Product;
import com.ecom.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/search")
	public List<Product> searchProducts(@RequestParam String query) {
		return productService.searchProducts(query);
	}

	@GetMapping("/category/{category}")
	public List<Product> getProductsByCategory(@PathVariable String category) {
		return productService.getProductsByCategory(category);
	}

	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	@PostMapping("/saveProduct")
	public ResponseEntity<Product> registorProduct(@RequestBody Product product) {
		Product saveProduct = productService.createProduct(product);
		return new ResponseEntity<Product>(saveProduct, HttpStatus.CREATED);
		
	}


}
