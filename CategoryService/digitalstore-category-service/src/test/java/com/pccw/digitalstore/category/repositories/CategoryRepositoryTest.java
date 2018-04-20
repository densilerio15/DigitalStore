package com.pccw.digitalstore.category.repositories;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pccw.digitalstore.category.models.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Test
    public void whenFindByName_thenReturnBrandWithName() {
    	//Given
    	Category nike = new Category("Shoes");
    	entityManager.persist(nike);
    	entityManager.flush();
    	
    	//When
    	Category retrievedBrand = categoryRepository.findByName("Shoes").get();
    	
    	//Then
    	assertThat(nike.getName(), is(equalTo(retrievedBrand.getName())));
    }

}
