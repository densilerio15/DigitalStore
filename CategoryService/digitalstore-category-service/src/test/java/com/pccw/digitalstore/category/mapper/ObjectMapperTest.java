package com.pccw.digitalstore.category.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import com.pccw.digitalstore.category.dto.CategoryPutDTO;
import com.pccw.digitalstore.category.models.Category;

public class ObjectMapperTest {
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Test
	public void whenConvertBrandEntityToBrandDto_thenCorrect() {
		Category brand = new Category(1l, "Shoes");
		CategoryPutDTO brandDto = modelMapper.map(brand, CategoryPutDTO.class);
		assertEquals(brand.getName(), brandDto.getName());
	}
	
	@Test
	public void whenConvertBrandDtoToBrandEntity_thenCorrect() {
		CategoryPutDTO brandDto = new CategoryPutDTO("Nike");
		CategoryPutDTO brand = modelMapper.map(brandDto, CategoryPutDTO.class);
		assertEquals(brand.getName(), brandDto.getName());
	}

}
