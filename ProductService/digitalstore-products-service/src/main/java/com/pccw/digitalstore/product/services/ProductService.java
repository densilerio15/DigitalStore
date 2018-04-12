package com.pccw.digitalstore.product.services;

import java.util.List;

import com.pccw.digitalstore.product.models.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	
	public List<Product> saveProductBatch(List<Product> productList);
	
	public Product getProduct(Long id);
	
	public Product getProductBySku(String sku);
	
	public List<Product> getAllProducts();
	
	public Product updateWholeProduct(Long id, Product product);
	
	public Product deleteProductById(Long id);
	
	public List<Product> getProductRecommendation(Long userId);

}
