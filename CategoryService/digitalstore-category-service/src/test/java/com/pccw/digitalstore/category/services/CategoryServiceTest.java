package com.pccw.digitalstore.category.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pccw.digitalstore.category.models.Category;
import com.pccw.digitalstore.category.repositories.CategoryRepository;

@RunWith(SpringRunner.class)
public class CategoryServiceTest {
	
    @Autowired
    private CategoryService categoryService;
    
	//Prevent this configuration to be pickup by our main configuration
    @TestConfiguration
    static class ProductServiceImplTestContextConfiguration {
        @Bean
        public CategoryService categoryService() {
            return new CategoryService();
        }
    }
    
    @MockBean
    private CategoryRepository categoryRepository;
    
    private Category nike = new Category(1l, "Nike");
    private Category adidas = new Category(2l, "Adidas");
    private Category pony = new Category(3l, "Pony");
    private Category converse = new Category(4l, "Converse");
    private Category jordan = new Category(5l, "Jordan");
    private List<Category> categoryList = Arrays.asList(nike, adidas, pony, converse, jordan);
    
    @Before
    public void setUp() {
    	
		Mockito.when(categoryRepository.findById(nike.getId())).thenReturn(Optional.of(nike));

		Mockito.when(categoryRepository.findByName(adidas.getName())).thenReturn(Optional.of(adidas));
		
		Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
		
		Mockito.when(categoryRepository.save(jordan)).thenReturn(jordan);
		
		Mockito.doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				return null;
            }
		}).when(categoryRepository).delete(pony);
		
    }
    
    @Test
    public void whenValidId_thenCategoryShouldBeFound() {
    	try {
    		Category found = categoryService.getCategory(nike.getId());
    		assertEquals(found.getId(), nike.getId());
    		assertThat(found, is(nike));
    	} catch(Exception e) {
    	}
    }
    
    @Test
    public void whenInvalidId_thenProductShouldThrowException() {
    	long dummyId = 234432l;
    	String exceptionMessage = "Resource requested not found with id = " + dummyId;
    	try {
    		categoryService.getCategory(dummyId);
    	} catch(Exception e) {
    		assertEquals(exceptionMessage, e.getMessage());
    	}
    }
    
    @Test
    public void whenValidName_thenCategoryShouldBeFound() {
    	try {
    		Category found = categoryService.getCategoryByName(nike.getName());
    		assertEquals(found.getName(), nike.getName());
    		assertThat(found, is(nike));
    	} catch(Exception e) {
    	}
    }
    
    @Test
    public void whenInvalidName_thenProductShouldThrowException() {
    	long dummyId = 234432l;
    	String exceptionMessage = "Resource requested not found with id = " + dummyId;
    	try {
    		categoryService.getCategory(dummyId);
    	} catch(Exception e) {
    		assertEquals(exceptionMessage, e.getMessage());
    	}
    }
    
    @Test
    public void whenfindAll_thenReturnAllProducts() {
		try {
			List<Category> foundCategorys = categoryService.getAllCategory();
			assertThat(foundCategorys, is(categoryList));
			assertThat(foundCategorys.size(), is(5));
		} catch (Exception e) {
		}
    }
    
	@Test
	public void whenUpdateWhole_thenReturnUpdatedProduct() {
		Category originalCategory = new Category(1l, "Salvimar");
		Optional<Category>  originalCategoryOptional = Optional.of(originalCategory);
		Category categoryUpdate = new Category(1l, "Salvimar v2");
		Mockito.when(categoryRepository.findById(originalCategory.getId())).thenReturn(originalCategoryOptional);
		Mockito.when(categoryRepository.save(categoryUpdate)).thenReturn(categoryUpdate);
		try {
			Category updatedProduct = categoryService.updateWholeCategory(originalCategory.getId(), categoryUpdate);
			assertThat(updatedProduct, is(categoryUpdate));
			assertThat(originalCategory.getId(), is(updatedProduct.getId()));
		} catch (Exception e) {
		}
	}

}
