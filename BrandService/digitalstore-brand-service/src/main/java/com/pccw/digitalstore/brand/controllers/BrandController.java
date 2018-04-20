package com.pccw.digitalstore.brand.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.digitalstore.brand.dto.BrandPutDTO;
import com.pccw.digitalstore.brand.dto.ResponseDTO;
import com.pccw.digitalstore.brand.models.Brand;
import com.pccw.digitalstore.brand.services.BrandService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/brand")
@Api(value = "Digital Store Brand API")
public class BrandController {

	@Autowired
	BrandService brandService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Fetch single brand based on ID", response = ResponseDTO.class)
	public ResponseDTO<Brand> getBrand(@PathVariable Long id) throws Exception {
		return new ResponseDTO<Brand>(brandService.getBrand(id));
	}

	@GetMapping(value = "/name/{brandName}", produces = "application/json")
	@ApiOperation(value = "Fetch single brand based on brand name", response = ResponseDTO.class)
	public ResponseDTO<Brand> getProductByName(
			@PathVariable String brandName) throws Exception {
		return new ResponseDTO<Brand>(brandService.getBrandByName(brandName));
	}

	@GetMapping(value = "/", produces = "application/json")
	@ApiOperation(value = "Fetch all brand stored", response = ResponseDTO.class)
	public ResponseDTO<List<Brand>> getAllBrands() throws Exception {
		return new ResponseDTO<List<Brand>>(brandService.getAllBrand());
	}

	@DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Delete one entry of brand with the specified ID", response = ResponseDTO.class)
	public ResponseDTO<Boolean> deleteBrand(@PathVariable Long id) throws Exception {
		return new ResponseDTO<Boolean>(brandService.deleteBrandById(id));
	}

	@PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Update the whole detail of a brand and preserve the ID", response = ResponseDTO.class)
	public ResponseDTO<Brand> updateProduct(@PathVariable Long id, @RequestBody BrandPutDTO brandDto) throws Exception {
		return new ResponseDTO<Brand>(brandService.updateWholeBrand(id, convertToEntity(brandDto)));
	}

	private Brand convertToEntity(BrandPutDTO brandDto) {
		return modelMapper.map(brandDto, Brand.class);
	}

}
