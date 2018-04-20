package com.pccw.digitalstore.category.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pccw.digitalstore.category.exceptions.ResourceNotFoundException;
import com.pccw.digitalstore.category.models.Category;
import com.pccw.digitalstore.category.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	private static final String NAME_KEY = "NAME";
	
	public Category getCategory(long id) throws Exception {
		return categoryRepository.findById(id).map((product) -> {
			return product;
		}).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Category getCategoryByName(String name) throws Exception {
		return categoryRepository.findByName(name).map((product) -> {
			return product;
		}).orElseThrow(() -> new ResourceNotFoundException(NAME_KEY, name));
	}
	
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}
	
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category updateWholeCategory(Long id, Category category) throws Exception {
		Optional<Category> currentCategory = categoryRepository.findById(id);
		return currentCategory.map(thisCategory -> {
			category.setId(thisCategory.getId());
			return categoryRepository.save(category);
		}).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public boolean deleteCategoryById(Long id) throws Exception {
		Optional<Category> currentProduct = categoryRepository.findById(id);
		return currentProduct.map(thisProduct -> {
			categoryRepository.deleteById(id);
			return true;
		}).orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
