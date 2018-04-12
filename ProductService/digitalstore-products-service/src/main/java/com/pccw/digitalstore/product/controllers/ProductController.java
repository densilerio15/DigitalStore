package com.pccw.digitalstore.product.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.digitalstore.product.dto.ResponseDTO;
import com.pccw.digitalstore.product.exception.ResourceNotFoundException;
import com.pccw.digitalstore.product.models.Product;
import com.pccw.digitalstore.product.repositories.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Value("${spring.application.name}")
	private String productServiceName;
	private final static String serviceStatusUp = "UP";
	private final static String transactionStatusSuccess = "SUCCESS";
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@GetMapping("/{id}")
	public ResponseDTO<Product> getProduct(@PathVariable Long id) throws Exception {
		Product returnProduct = productRepository.findById(id).map(obj -> {return obj;})
																.orElseThrow(() -> new ResourceNotFoundException(id));
		ResponseDTO<Product> responseDto = new ResponseDTO<>(transactionStatusSuccess, returnProduct);
		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
		return responseDto;
	}
	
	@GetMapping("/sku/{sku}")
	public ResponseDTO<Product> getProductBySku(@PathVariable String sku) throws Exception {
		Product returnProduct = productRepository.findBySku(sku);
		if(returnProduct == null) {
			throw new ResourceNotFoundException("sku", sku);
		}
		ResponseDTO<Product> responseDto = new ResponseDTO<>(transactionStatusSuccess, productRepository.findBySku(sku));
		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
		return responseDto;
	}
	
	
	@GetMapping("/all")
	public ResponseDTO<List<Product>> getAllProducts() {
		ResponseDTO<List<Product>> responseDto = new ResponseDTO<>(transactionStatusSuccess, productRepository.findAll());
		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
		return responseDto;
	}
	
	@PostMapping("/batch")
	public ResponseDTO<List<Product>> createBatchProduct(@RequestBody Product[] productList) {
		ResponseDTO<List<Product>> responseDto = new ResponseDTO<>(transactionStatusSuccess, 
																	productRepository.saveAll(Arrays.asList(productList)));
		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
		return responseDto;
		
	}
	
	@PutMapping("/{id}")
	public ResponseDTO<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) throws Exception {
		Optional<Product> currentProduct = productRepository.findById(id);
		return currentProduct.map(obj -> {
					                obj = product;
					        		ResponseDTO<Product> responseDto = new ResponseDTO<>(transactionStatusSuccess, 
					        																productRepository.save(obj));
					        		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
					        		return responseDto;
								})
								.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseDTO<Product> deleteProduct(@PathVariable Long id) throws Exception {
		Optional<Product> currentProduct = productRepository.findById(id);
		if(currentProduct.isPresent()) {
			productRepository.deleteById(id);
    		ResponseDTO<Product> responseDto = new ResponseDTO<>(transactionStatusSuccess, currentProduct.get());
			responseDto.addServiceStatus(productServiceName, serviceStatusUp);
			return responseDto;
		} else {
			throw new ResourceNotFoundException(id);
		}
	}
	
	@GetMapping("/recommendation/{userId}")
	public ResponseDTO<List<Product>> getRecommendedProducts() {
		ResponseDTO<List<Product>> responseDto = new ResponseDTO<>(transactionStatusSuccess, productRepository.findAll());
		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
		return responseDto;
	}
}
