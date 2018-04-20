package com.pccw.digitalstore.brand;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.pccw.digitalstore.brand.models.Brand;
import com.pccw.digitalstore.brand.repositories.BrandRepository;

@Component
@Order(1)
public class PupulateInitialDataBase implements CommandLineRunner {
	
	@Autowired
	BrandRepository brandRepository;
	
	private static final String INITIALIZE_DB = "initialize-data";
	
	@Override
	public void run(String...args) throws Exception {
		boolean initializeData = Arrays.stream(args).anyMatch((command) -> {
			return INITIALIZE_DB.equals(command);
		});
		
		if(initializeData) {
			brandRepository.save(new Brand("Nike"));
			brandRepository.save(new Brand("Adidas"));
			brandRepository.save(new Brand("Pony"));
			brandRepository.save(new Brand("Converse"));
			brandRepository.save(new Brand("Jordan"));
		}
	}

}
