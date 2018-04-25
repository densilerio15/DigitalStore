package com.pccw.digitalstore.DigitalStoreApp.services;

import java.util.List;

import com.pccw.digitalstore.DigitalStoreApp.Models.Product;
import com.pccw.digitalstore.DigitalStoreApp.repositories.ProductWrapper;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ProductServiceClient {
	@RequestLine("GET /{id}")
	ProductWrapper getProductById(@Param("id") String productId);

	@RequestLine("GET")
	List<ProductWrapper> getAllProduct();

	@RequestLine("POST")
	@Headers("Content-Type: application/json")
	void create(Product product);
}
