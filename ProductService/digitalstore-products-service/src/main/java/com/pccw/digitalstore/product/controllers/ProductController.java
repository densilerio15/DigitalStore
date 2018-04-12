package com.pccw.digitalstore.product.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.digitalstore.product.dto.ResponseDTO;
import com.pccw.digitalstore.product.models.Product;
import com.pccw.digitalstore.product.repositories.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@GetMapping("/{id}")
	public ResponseDTO getProduct(@PathVariable Long id) {
		Map<String, String> serviceStatus = new HashMap<>();
		Map<String, String> transactionStatus = new HashMap<>();
		serviceStatus.put("Test Service", "UP");
		transactionStatus.put("No Error", "No error here");
		return new ResponseDTO(serviceStatus, "success", productRepository.getOne(id), transactionStatus);
	}
	
	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@PostMapping("/batch")
	public List<Product> createBatchProduct(@RequestBody Product[] productList) {
		List<Product> productResult = new ArrayList<>();
		for(Product product : productList) {
			productResult.add(productRepository.save(product));
		}
		return productResult;
	}

}
