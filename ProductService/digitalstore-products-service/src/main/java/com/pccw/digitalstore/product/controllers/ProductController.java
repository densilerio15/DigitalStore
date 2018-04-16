package com.pccw.digitalstore.product.controllers;

import java.util.Arrays;
import java.util.List;

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
import com.pccw.digitalstore.product.models.Product;
import com.pccw.digitalstore.product.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Value("${spring.application.name}")
	private String productServiceName;
	private final static String serviceStatusUp = "UP";
	private final static String transactionStatusSuccess = "SUCCESS";
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/")
	public Product createProduct(@RequestBody Product product) throws Exception {
		return productService.saveProduct(product);
	}
	
	@GetMapping("/{id}")
	public ResponseDTO<Product> getProduct(@PathVariable Long id) throws Exception {
		ResponseDTO<Product> responseDto = new ResponseDTO<>(transactionStatusSuccess, productService.getProduct(id));
		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
		return responseDto;
	}
	
	@GetMapping("/sku/{sku}")
	public ResponseDTO<Product> getProductBySku(@PathVariable String sku) throws Exception {
		ResponseDTO<Product> responseDto = new ResponseDTO<>(transactionStatusSuccess,
				productService.getProductBySku(sku));
		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
		return responseDto;
	}
	
	
	@GetMapping("/all")
	public ResponseDTO<List<Product>> getAllProducts() throws Exception {
		ResponseDTO<List<Product>> responseDto = new ResponseDTO<>(transactionStatusSuccess,
				productService.getAllProducts());
		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
		return responseDto;
	}
	
	@PostMapping("/batch")
	public ResponseDTO<List<Product>> createBatchProduct(@RequestBody Product[] productList) throws Exception {
		ResponseDTO<List<Product>> responseDto = new ResponseDTO<>(transactionStatusSuccess, 
					productService.saveProductBatch((Arrays.asList(productList))));
		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
		return responseDto;
	}

	@PutMapping("/{id}")
	public ResponseDTO<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) throws Exception {
		ResponseDTO<Product> responseDto = new ResponseDTO<>(transactionStatusSuccess,
				productService.updateWholeProduct(id, product));
		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
		return responseDto;
	}

	@DeleteMapping("/{id}")
	public ResponseDTO<Boolean> deleteProduct(@PathVariable Long id) throws Exception {
		ResponseDTO<Boolean> responseDto = new ResponseDTO<>(transactionStatusSuccess,
				productService.deleteProductById(id));
		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
		return responseDto;
	}

	@GetMapping("/recommendation/{userId}")
	public ResponseDTO<List<Product>> getRecommendedProducts(@PathVariable Long userId) throws Exception {
		ResponseDTO<List<Product>> responseDto = new ResponseDTO<>(transactionStatusSuccess,
				productService.getProductRecommendation(userId));
		responseDto.addServiceStatus(productServiceName, serviceStatusUp);
		return responseDto;
	}
}
