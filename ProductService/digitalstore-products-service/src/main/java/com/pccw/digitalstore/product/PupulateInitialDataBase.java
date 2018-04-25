package com.pccw.digitalstore.product;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.pccw.digitalstore.product.models.Product;
import com.pccw.digitalstore.product.repositories.ProductRepository;
import com.pccw.digitalstore.product.services.StorageService;

@Component
@Order(1)
public class PupulateInitialDataBase implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(PupulateInitialDataBase.class);

	@Autowired
	ProductRepository productRepository;

	@Autowired
	@Qualifier("fileSystemStroageService")
	StorageService storageService;

	private static final String INITIALIZE_DB = "initialize-data";

	@Override
	public void run(String... args) throws Exception {
		boolean initializeData = Arrays.asList(args).stream().anyMatch((command) -> {
			return INITIALIZE_DB.equals(command);
		});

		if (initializeData) {
			LOGGER.info("Detected command ({}) from the start up args.", INITIALIZE_DB);
			LOGGER.info("Will start products service with test data and delete all products image.");
			
			storageService.deleteAll();
			productRepository.save(new Product("nike_1234", "Nike Air 270", 270.32d, 36d, 1, 10));
			productRepository.save(new Product("adidas_1551", "UltraBoosts", 2730.32d, 56d, 8, 13));
			productRepository.save(new Product("332_zalora", "Zalora Air Boost", 764.32d, 36d, 1, 0));
			productRepository.save(new Product("Star_bu_cks321", "Kupi", 180d, 3.6d, 100, 13));
			productRepository.save(new Product("aysus", "Laptop", 1820d, 3.65d, 1003, 134));
		}
	}
}
