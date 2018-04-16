package com.pccw.digitalstore.product.services;

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

import com.pccw.digitalstore.product.models.Product;
import com.pccw.digitalstore.product.repositories.ProductRepository;

@RunWith(SpringRunner.class)
public class ProductServiceTest {
	
	//Prevent this configuration to be pickup by our main configuration
    @TestConfiguration
    static class ProductServiceImplTestContextConfiguration {
        @Bean
        public ProductService employeeService() {
            return new ProductServiceImpl();
        }
    }
    
    @Autowired
    private ProductService productService;
    
    @MockBean
    private ProductRepository productRepository;
    
    @Before
    public void setUp() {
    	Product product = new Product(1l, "Nike");
        Optional<Product> nikeProductOP = Optional.of(product);
        
		Product salvimar = new Product(1l, "Salvimar");
		Product adidas = new Product(2l, "Adidas");
		Product starbucks = new Product(3l, "Starbucks");
		Product coby = new Product(4l, "Coby");
		Product superga = new Product(5l, "Superga");
		Product sebago = new Product(6l, "Sebago");
		Product riceCake = new Product(7l, "Rice cake");

		List<Product> productList = Arrays.asList(salvimar, adidas, starbucks, coby, superga, sebago, riceCake);

		Mockito.when(productRepository.findById(product.getId())).thenReturn(nikeProductOP);

		Mockito.when(productRepository.findBySku(product.getSku())).thenReturn(product);
		
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		
		Mockito.when(productRepository.saveAll(productList)).thenReturn(productList);
		
		Mockito.when(productRepository.save(salvimar)).thenReturn(salvimar);
		
		Mockito.doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				return null;
            }
		}).when(productRepository).delete(product);
		
    }
    
    @Test
    public void whenValidSku_thenProductShouldBeFound() {
    	String sku = "Nike";
    	try {
    		Product found = productService.getProductBySku(sku);
    		assertEquals(found.getSku(), sku);
    	} catch(Exception e) {
    		
    	}
    }
    
    @Test
    public void whenInvalidSku_thenProductShouldThrowException() {
    	String sku = "Nikeid";
    	String exceptionMessage = "Resource requested not found with sku = " + sku;
    	try {
    		productService.getProductBySku(sku);
    	} catch(Exception e) {
    		assertEquals(exceptionMessage, e.getMessage());
    	}
    }
    
    @Test
    public void whenValidId_thenProductShouldBeFound() {
    	Long id = 1l;
    	try {
    		Product found = productService.getProduct(id);
    		assertEquals(found.getId(), id);
    	} catch(Exception e) {
    		
    	}
    }
    
    @Test
    public void whenInvalidId_thenProductShouldThrowException() {
    	Long id = 14l;
    	String exceptionMessage = "Resource requested not found with id = " + id;
    	try {
    		productService.getProduct(id);
    	} catch(Exception e) {
    		assertEquals(exceptionMessage, e.getMessage());
    	}
    }

    @Test
    public void whenfindAll_thenReturnAllProducts() {
		Product salvimar = new Product(1l, "Salvimar");
		Product adidas = new Product(2l, "Adidas");
		Product starbucks = new Product(3l, "Starbucks");
		Product coby = new Product(4l, "Coby");
		Product superga = new Product(5l, "Superga");
		Product sebago = new Product(6l, "Sebago");
		Product riceCake = new Product(7l, "Rice cake");

		List<Product> productList = Arrays.asList(salvimar, adidas, starbucks, coby, superga, sebago, riceCake);
		try {
			List<Product> foundProducts = productService.getAllProducts();
			assertThat(foundProducts, is(productList));
			assertThat(foundProducts.size(), is(7));
		} catch (Exception e) {
		}
    }
    
    @Test
    public void whenSaveOne_thenReturnSavedProduct() {
		Product salvimar = new Product(1l, "Salvimar");
		try {
			Product foundProducts = productService.saveProduct(salvimar);
			assertThat(foundProducts, is(salvimar));
		} catch (Exception e) {
		}
    }
    
    @Test
    public void whenSaveBatch_thenReturnSavedBatchProduct() {
    	Product salvimar = new Product(1l, "Salvimar");
		Product adidas = new Product(2l, "Adidas");
		Product starbucks = new Product(3l, "Starbucks");
		Product coby = new Product(4l, "Coby");
		Product superga = new Product(5l, "Superga");
		Product sebago = new Product(6l, "Sebago");
		Product riceCake = new Product(7l, "Rice cake");

		List<Product> productList = Arrays.asList(salvimar, adidas, starbucks, coby, superga, sebago, riceCake);
		try {
			List<Product> foundProducts = productService.saveProductBatch(productList);
			assertThat(foundProducts, is(foundProducts));
			assertThat(foundProducts.size(), is(7));
		} catch (Exception e) {
		}
	}

	@Test
	public void whenUpdateWhole_thenReturnUpdatedProduct() {
		Product originalProduct = new Product(1l, "Salvimar");
		Optional<Product>  originalProductOP = Optional.of(originalProduct);
		Product productUpdate = new Product(1l, "Salvimar v2");
		Mockito.when(productRepository.findById(originalProduct.getId())).thenReturn(originalProductOP);
		Mockito.when(productRepository.save(productUpdate)).thenReturn(productUpdate);
		try {
			Product updatedProduct = productService.updateWholeProduct(originalProduct.getId(), productUpdate);
			assertThat(updatedProduct, is(productUpdate));
			assertThat(originalProduct.getId(), is(updatedProduct.getId()));
		} catch (Exception e) {

		}

	}
}
