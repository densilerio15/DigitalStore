package com.pccw.digitalstore.product.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.digitalstore.product.dto.ProductImageDTO;
import com.pccw.digitalstore.product.dto.ResponseDTO;
import com.pccw.digitalstore.product.models.Product;
import com.pccw.digitalstore.product.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/products")
@Api(value = "Digital Store Products API")
public class ProductController {

	@Autowired
	ProductService productService;
	

	@PostMapping(value = "/", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Create single product", response = ResponseDTO.class)
	public ResponseDTO<Product> createProduct(@RequestBody Product product) throws Exception {
		return new ResponseDTO<Product>(productService.saveProduct(product));
	}
	
	@PostMapping(value = "/image", produces = "application/json", consumes = "application/json", headers = "content-type=multipart/form-data")
	@ApiOperation(value = "Create single product with image", response = ResponseDTO.class)
	public ResponseDTO<Product> createProductWithImage(@ModelAttribute ProductImageDTO product) throws Exception {
		return new ResponseDTO<Product>(productService.saveProductWithImage((product)));
	}

	@GetMapping(value = "/{productId}", produces = "application/json")
	@ApiOperation(value = "Fetch single product based on ID", response = ResponseDTO.class)
	public ResponseDTO<Product> getProduct(@PathVariable Long productId) throws Exception {
		return new ResponseDTO<Product>(productService.getProduct(productId));
	}

	@GetMapping(value = "/sku/{sku}", produces = "application/json")
	@ApiOperation(value = "Fetch single product based on SKU", response = ResponseDTO.class)
	public ResponseDTO<Product> getProductBySku(@PathVariable String sku) throws Exception {
		return new ResponseDTO<Product>(productService.getProductBySku(sku));
	}

	@GetMapping(value = "/all", produces = "application/json")
	@ApiOperation(value = "Fetch all products stored", response = ResponseDTO.class)
	public ResponseDTO<List<Product>> getAllProducts() throws Exception {
		return new ResponseDTO<List<Product>>(productService.getAllProducts());
	}

	@PostMapping(value = "/batch", produces = "application/json")
	@ApiOperation(value = "Create multiple products", response = ResponseDTO.class)
	public ResponseDTO<List<Product>> createBatchProduct(@RequestBody Product[] productList) throws Exception {
		return new ResponseDTO<List<Product>>(productService.saveProductBatch((Arrays.asList(productList))));
	}

	@PutMapping(value = "/{productId}", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Update the whole detail of a product and preserve the ID", response = ResponseDTO.class)
	public ResponseDTO<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product)
			throws Exception {
		return new ResponseDTO<Product>(productService.updateWholeProduct(productId, product));
	}

	@DeleteMapping(value = "/{productId}", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Update the whole detail of a product and preserve the ID", response = ResponseDTO.class)
	public ResponseDTO<Boolean> deleteProduct(@PathVariable Long productId) throws Exception {
		return new ResponseDTO<Boolean>(productService.deleteProductById(productId));
	}

	@GetMapping(value = "/recommendation/{userId}", produces = "application/json")
	@ApiOperation(value = "Fetch list of recommended products based on user history purchase", response = ResponseDTO.class)
	public ResponseDTO<List<Product>> getRecommendedProducts(@PathVariable Long userId) throws Exception {
		return new ResponseDTO<List<Product>>(productService.getProductRecommendation(userId));
	}

	@GetMapping(value = "/recommendation/", produces = "application/json")
	@ApiOperation(value = "Fetch list of recommended products based on user age and gender", response = ResponseDTO.class)
	public ResponseDTO<List<Product>> getRecommendedProducts(
			@RequestParam @ApiParam(value = "ID of the customer") Integer age, @RequestParam String gender)
			throws Exception {
		return new ResponseDTO<List<Product>>(productService.getProductRecommendationByUserMetrix(age, gender));
	}

	@PatchMapping(value = "/{productId}", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Update each product fields and retain the product ID and SKU", response = ResponseDTO.class)
	public ResponseDTO<Product> updateProductFields(@PathVariable Long productId,
			@RequestBody Map<String, Object> fields) throws Exception {
		return new ResponseDTO<Product>(productService.updateProductFields(productId, fields));
	}
	
}
