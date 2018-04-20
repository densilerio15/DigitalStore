package com.pccw.digitalstore.brand.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import com.pccw.digitalstore.brand.dto.BrandPutDTO;
import com.pccw.digitalstore.brand.models.Brand;

public class ObjectMapperTest {
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Test
	public void whenConvertBrandEntityToBrandDto_thenCorrect() {
		Brand brand = new Brand(1l, "Nike");
		BrandPutDTO brandDto = modelMapper.map(brand, BrandPutDTO.class);
		assertEquals(brand.getName(), brandDto.getName());
	}
	
	@Test
	public void whenConvertBrandDtoToBrandEntity_thenCorrect() {
		BrandPutDTO brandDto = new BrandPutDTO("Nike");
		Brand brand = modelMapper.map(brandDto, Brand.class);
		assertEquals(brand.getName(), brandDto.getName());
	}

}
