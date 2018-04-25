package com.pccw.digitalstore.DigitalStoreApp.repositories;

import com.pccw.digitalstore.DigitalStoreApp.Models.Product;

public class ProductWrapper {
	public ProductWrapper(Product product) {
		super();
		this.product = product;
	}

	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
