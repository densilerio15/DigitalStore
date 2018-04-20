package com.pccw.digitalstore.category;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.pccw.digitalstore.category.models.Category;
import com.pccw.digitalstore.category.repositories.CategoryRepository;

@Component
@Order(1)
public class PupulateInitialDataBase implements CommandLineRunner {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	private static final String INITIALIZE_DB = "initialize-data";
	
	@Override
	public void run(String...args) throws Exception {
		boolean initializeData = Arrays.stream(args).anyMatch((command) -> {
			return INITIALIZE_DB.equals(command);
		});
		
		if(initializeData) {
			categoryRepository.save(new Category("Shoes"));
			categoryRepository.save(new Category("Pants"));
			categoryRepository.save(new Category("Phones"));
			categoryRepository.save(new Category("Furniture"));
			categoryRepository.save(new Category("Kitchenware"));
		}
	}

}
