package com.pccw.digitalstore.brand.repositories;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pccw.digitalstore.brand.models.Brand;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BrandRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private BrandRepository brandRepository;
    
    @Test
    public void whenFindByName_thenReturnBrandWithName() {
    	//Given
    	Brand nike = new Brand("Nike");
    	entityManager.persist(nike);
    	entityManager.flush();
    	
    	//When
    	Brand retrievedBrand = brandRepository.findByName("Nike").get();
    	
    	//Then
    	assertThat(nike.getName(), is(equalTo(retrievedBrand.getName())));
    }

}
