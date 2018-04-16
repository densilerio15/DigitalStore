package com.pccw.digitalstore.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DigitalstoreProductsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalstoreProductsServiceApplication.class, args);
	}
}
