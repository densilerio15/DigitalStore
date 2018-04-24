package com.pccw.digitalstore.product.services;

import java.util.List;
import java.util.Map;

import com.pccw.digitalstore.product.dto.ProductImageDTO;
import com.pccw.digitalstore.product.models.Product;

public interface ProductService {
	
	public Product saveProduct(Product product) throws Exception;
	
	public List<Product> saveProductBatch(List<Product> productList) throws Exception;
	
	public Product getProduct(Long id) throws Exception;
	
	public Product getProductBySku(String sku) throws Exception;
	
	public List<Product> getProductRecommendation(Long userId) throws Exception;
	
	public List<Product> getProductRecommendationByUserMetrix(Integer age, String Gender) throws Exception;
	
	public List<Product> getAllProducts() throws Exception;
	
	public Product updateWholeProduct(Long id, Product product) throws Exception;
	
	public boolean deleteProductById(Long id) throws Exception;
	
	public Product updateProductFields(Long id, Map<String, Object> fields) throws Exception;
	
	public Product saveProductWithImage(ProductImageDTO product) throws Exception;
	
}
