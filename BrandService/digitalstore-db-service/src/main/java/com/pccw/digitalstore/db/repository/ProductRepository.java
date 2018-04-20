package com.pccw.digitalstore.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pccw.digitalstore.db.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findBySku(String sku);
	
	Product findByName(String name);
	
}
