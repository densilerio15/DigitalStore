package com.pccw.digitalstore.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.pccw.digitalstore.db.model.Product;
import com.pccw.digitalstore.db.repository.ProductRepository;

@Component
@Order(1)
public class PupulateInitialDataBase implements CommandLineRunner {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void run(String...args) throws Exception {
		productRepository.save(new Product("nike_1234", "Nike Air 270", 270.32d, 36d, 1, 10));
		productRepository.save(new Product("adidas_1551", "UltraBoosts", 2730.32d, 56d, 8, 13));
		productRepository.save(new Product("332_zalora", "Zalora Air Boost", 764.32d, 36d, 1, 0));
		productRepository.save(new Product("Star_bu_cks321", "Kupi", 180d, 3.6d, 100, 13));
		productRepository.save(new Product("aysus", "Laptop", 1820d, 3.65d, 1003, 134));
		
	}

}
