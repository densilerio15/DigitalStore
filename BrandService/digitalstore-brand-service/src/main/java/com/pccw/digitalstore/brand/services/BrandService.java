package com.pccw.digitalstore.brand.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pccw.digitalstore.brand.exception.ResourceNotFoundException;
import com.pccw.digitalstore.brand.models.Brand;
import com.pccw.digitalstore.brand.repositories.BrandRepository;

@Service
public class BrandService {
	
	@Autowired
	BrandRepository brandRepository;
	
	private static final String NAME_KEY = "NAME";
	
	public Brand getBrand(long id) throws Exception {
		return brandRepository.findById(id).map((product) -> {
			return product;
		}).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Brand getBrandByName(String name) throws Exception {
		return brandRepository.findByName(name).map((product) -> {
			return product;
		}).orElseThrow(() -> new ResourceNotFoundException(NAME_KEY, name));
	}
	
	public List<Brand> getAllBrand() {
		return brandRepository.findAll();
	}
	
	public Brand saveBrand(Brand brand) {
		return brandRepository.save(brand);
	}
	
	public Brand updateWholeBrand(Long id, Brand brand) throws Exception {
		Optional<Brand> currentBrand = brandRepository.findById(id);
		return currentBrand.map(thisBrand -> {
			thisBrand = brand;
			return brandRepository.save(thisBrand);
		}).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public boolean deleteBrandById(Long id) throws Exception {
		Optional<Brand> currentProduct = brandRepository.findById(id);
		return currentProduct.map(thisProduct -> {
			brandRepository.deleteById(id);
			return true;
		}).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
}
