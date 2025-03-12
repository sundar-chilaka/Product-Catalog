package com.ecom.model;

import lombok.Data;

@Data
public class OrderRequest {
	private String productId;
	private int quantity;
}
