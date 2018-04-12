package com.pccw.digitalstore.product.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pccw.digitalstore.product.models.Product;
import com.pccw.digitalstore.product.repositories.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ProductRepository productRepository;
    
    @Test
    public void whenFindBySku_thenReturnProductWithSku() {
    	//Given
    	Product nikeSku = new Product("Nike");
    	entityManager.persist(nikeSku);
    	entityManager.flush();
    	
    	//When
    	Product retrievedProduct = productRepository.findBySku("Nike");
    	
    	//Then
    	assertEquals(nikeSku.getSku(), retrievedProduct.getSku());
    }
    
    @Test
    public void whenFindByName_thenReturnProductWithName() {
    	//Given
    	Product nike = new Product("Nike");
    	nike.setName("Nike Air");
    	entityManager.persist(nike);
    	entityManager.flush();
    	
    	//When
    	Product retrievedProduct = productRepository.findByName("Nike Air");
    	
    	//Then
    	assertEquals(nike.getName(), retrievedProduct.getName());
    	
    }

}
