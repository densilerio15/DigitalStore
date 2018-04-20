package com.pccw.digitalstore.db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pccw.digitalstore.db.exception.ResourceNotFoundException;
import com.pccw.digitalstore.db.model.Product;
import com.pccw.digitalstore.db.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> saveProductBatch(List<Product> productList) {
		return productRepository.saveAll(productList);
	}

	@Override
	public Product getProduct(Long id) throws Exception {
		return productRepository.findById(id).map((product) -> {
					return product;
				}).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Override
	public Product getProductBySku(String sku) throws Exception {
		Product product = productRepository.findBySku(sku);
		if(product == null) {
			throw new ResourceNotFoundException("sku", sku);
		}
		return product;
	}

	@Override
	public List<Product> getProductRecommendation(Long userId) throws Exception {
		// TODO Logic for fetching recommended product based on user's purchase history
		return this.getAllProducts();
	}

	@Override
	public List<Product> getProductRecommendationByUserMetrix(Integer age, String Gender) throws Exception {
		// TODO Logic for fetching recommended product based on the details the FRS detected
		return this.getAllProducts();
	}

	@Override
	public List<Product> getAllProducts() throws Exception {
		List<Product> allProductList = productRepository.findAll();
		if(allProductList == null || allProductList.size() <= 0) {
			throw new ResourceNotFoundException();
		}
		return allProductList;
	}

	@Override
	public Product updateWholeProduct(Long id, Product product) throws Exception {
		Optional<Product> currentProduct = productRepository.findById(id);
		return currentProduct.map(thisProduct -> {
			thisProduct = product;
			return productRepository.save(thisProduct);
		}).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Override
	public boolean deleteProductById(Long id) throws Exception {
		Optional<Product> currentProduct = productRepository.findById(id);
		return currentProduct.map(thisProduct -> {
			productRepository.deleteById(id);
			return true;
		}).orElseThrow(() -> new ResourceNotFoundException(id));
	}

}
