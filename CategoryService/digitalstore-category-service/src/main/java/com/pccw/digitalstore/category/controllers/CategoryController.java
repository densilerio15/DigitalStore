package com.pccw.digitalstore.category.controllers;

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

import com.pccw.digitalstore.category.dto.CategoryPutDTO;
import com.pccw.digitalstore.category.dto.ResponseDTO;
import com.pccw.digitalstore.category.models.Category;
import com.pccw.digitalstore.category.services.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/category")
@Api(value = "Digital Store Category API")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Fetch single category based on ID", response = ResponseDTO.class)
	public ResponseDTO<Category> getCategory(@PathVariable Long id) throws Exception {
		return new ResponseDTO<Category>(categoryService.getCategory(id));
	}

	@GetMapping(value = "/name/{categoryName}", produces = "application/json")
	@ApiOperation(value = "Fetch single category based on category name", response = ResponseDTO.class)
	public ResponseDTO<Category> getProductByName(
			@PathVariable String categoryName)
			throws Exception {
		return new ResponseDTO<Category>(categoryService.getCategoryByName(categoryName));
	}

	@GetMapping(value = "/", produces = "application/json")
	@ApiOperation(value = "Fetch all category stored", response = ResponseDTO.class)
	public ResponseDTO<List<Category>> getAllCategorys() throws Exception {
		return new ResponseDTO<List<Category>>(categoryService.getAllCategory());
	}

	@DeleteMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Delete one entry of category with the specified ID", response = ResponseDTO.class)
	public ResponseDTO<Boolean> deleteCategory(@PathVariable Long id) throws Exception {
		return new ResponseDTO<Boolean>(categoryService.deleteCategoryById(id));
	}

	@PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Update the whole detail of a category and preserve the ID", response = ResponseDTO.class)
	public ResponseDTO<Category> updateProduct(@PathVariable Long id, @RequestBody CategoryPutDTO categoryDto)
			throws Exception {
		return new ResponseDTO<Category>(categoryService.updateWholeCategory(id, convertToEntity(categoryDto)));
	}

	private Category convertToEntity(CategoryPutDTO categoryDto) {
		return modelMapper.map(categoryDto, Category.class);
	}
}
