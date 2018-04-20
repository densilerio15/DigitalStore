package com.pccw.digitalstore.brand.services;

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

import com.pccw.digitalstore.brand.models.Brand;
import com.pccw.digitalstore.brand.repositories.BrandRepository;
import com.pccw.digitalstore.brand.services.BrandService;

@RunWith(SpringRunner.class)
public class BrandServiceTest {
	
    @Autowired
    private BrandService brandService;
    
	//Prevent this configuration to be pickup by our main configuration
    @TestConfiguration
    static class ProductServiceImplTestContextConfiguration {
        @Bean
        public BrandService brandService() {
            return new BrandService();
        }
    }
    
    @MockBean
    private BrandRepository brandRepository;
    
    private Brand nike = new Brand(1l, "Nike");
    private Brand adidas = new Brand(2l, "Adidas");
    private Brand pony = new Brand(3l, "Pony");
    private Brand converse = new Brand(4l, "Converse");
    private Brand jordan = new Brand(5l, "Jordan");
    private List<Brand> brandList = Arrays.asList(nike, adidas, pony, converse, jordan);
    
    @Before
    public void setUp() {
    	
		Mockito.when(brandRepository.findById(nike.getId())).thenReturn(Optional.of(nike));

		Mockito.when(brandRepository.findByName(adidas.getName())).thenReturn(Optional.of(adidas));
		
		Mockito.when(brandRepository.findAll()).thenReturn(brandList);
		
		Mockito.when(brandRepository.save(jordan)).thenReturn(jordan);
		
		Mockito.doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				return null;
            }
		}).when(brandRepository).delete(pony);
		
    }
    
    @Test
    public void whenValidId_thenBrandShouldBeFound() {
    	try {
    		Brand found = brandService.getBrand(nike.getId());
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
    		brandService.getBrand(dummyId);
    	} catch(Exception e) {
    		assertEquals(exceptionMessage, e.getMessage());
    	}
    }
    
    @Test
    public void whenValidName_thenBrandShouldBeFound() {
    	try {
    		Brand found = brandService.getBrandByName(nike.getName());
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
    		brandService.getBrand(dummyId);
    	} catch(Exception e) {
    		assertEquals(exceptionMessage, e.getMessage());
    	}
    }
    
    @Test
    public void whenfindAll_thenReturnAllProducts() {
		try {
			List<Brand> foundBrands = brandService.getAllBrand();
			assertThat(foundBrands, is(brandList));
			assertThat(foundBrands.size(), is(5));
		} catch (Exception e) {
		}
    }
    
	@Test
	public void whenUpdateWhole_thenReturnUpdatedProduct() {
		Brand originalBrand = new Brand(1l, "Salvimar");
		Optional<Brand>  originalBrandOptional = Optional.of(originalBrand);
		Brand brandUpdate = new Brand(1l, "Salvimar v2");
		Mockito.when(brandRepository.findById(originalBrand.getId())).thenReturn(originalBrandOptional);
		Mockito.when(brandRepository.save(brandUpdate)).thenReturn(brandUpdate);
		try {
			Brand updatedProduct = brandService.updateWholeBrand(originalBrand.getId(), brandUpdate);
			assertThat(updatedProduct, is(brandUpdate));
			assertThat(originalBrand.getId(), is(updatedProduct.getId()));
		} catch (Exception e) {
		}
	}

}
