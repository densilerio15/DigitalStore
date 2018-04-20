package com.pccw.digitalstore.brand.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.digitalstore.brand.dto.ResponseDTO;
import com.pccw.digitalstore.brand.models.Brand;
import com.pccw.digitalstore.brand.services.BrandService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/products")
@Api(value = "Digital Store Brand API")
public class BrandController {
	
	@Autowired
	BrandService brandService;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Fetch single brand based on ID", response = ResponseDTO.class)
	public ResponseDTO<Brand> getProduct(@PathVariable Long id) throws Exception {
		return new ResponseDTO<Brand>(brandService.getBrand(id));
	}
	
	@GetMapping(value = "/brand/{id}", produces = "application/json")
	@ApiOperation(value = "Fetch single brand based on brand name", response = ResponseDTO.class)
	public ResponseDTO<Brand> getProduct(@PathVariable String brandName) throws Exception {
		return new ResponseDTO<Brand>(brandService.getBrandByName(brandName));
	}
	
	@GetMapping(value = "/", produces = "application/json")
	@ApiOperation(value = "Fetch all brand stored", response = ResponseDTO.class)
	public ResponseDTO<List<Brand>> getAllProducts() throws Exception {
		return new ResponseDTO<List<Brand>>(brandService.getAllBrand());
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Delete one entry of brand with the specified ID", response = ResponseDTO.class)
	public ResponseDTO<Boolean> deleteProduct(@PathVariable Long id) throws Exception {
		return new ResponseDTO<Boolean>(brandService.deleteBrandById(id));
	}

	
}
