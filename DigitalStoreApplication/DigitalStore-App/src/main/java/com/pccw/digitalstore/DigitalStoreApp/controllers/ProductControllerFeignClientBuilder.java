package com.pccw.digitalstore.DigitalStoreApp.controllers;

import com.pccw.digitalstore.DigitalStoreApp.services.ProductServiceClient;

@Getter
public class ProductControllerFeignClientBuilder {
	private ProductServiceClient prodClient = createClient(ProductClient.class, "http://localhost:8881/products/all");
}
