package com.libertyglobal.PotatoMarket;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.libertyglobal.PotatoMarket.data.PotatoBagRepository;
import com.libertyglobal.PotatoMarket.model.PotatoBag;

/**
 * Test for checking JPA Repository method 
 * org.springframework.data.repository.PagingAndSortingRepository.findAll(Pageable arg0)
 * @author Rabindra Rakshit
 *
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class PotatoRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private PotatoBagRepository potatoBagRepository;
    
    @Test
    public void whenFindAllPageable_thenReturnSameCount() {
        // given
        
    	PotatoBag potatoBag1=new PotatoBag();
    	PotatoBag potatoBag2=new PotatoBag();
    	PotatoBag potatoBag3=new PotatoBag();
    	
    	potatoBag1.setNumberOfPotatoes(3);
    	potatoBag1.setPackagedDateTime(LocalDateTime.now());
    	potatoBag1.setPrice(34);
    	potatoBag1.setSupplier("Owel");
    	
    	potatoBag2.setNumberOfPotatoes(3);
    	potatoBag2.setPackagedDateTime(LocalDateTime.now());
    	potatoBag2.setPrice(34);
    	potatoBag2.setSupplier("Owel");
     
    	potatoBag3.setNumberOfPotatoes(3);
    	potatoBag3.setPackagedDateTime(LocalDateTime.now());
    	potatoBag3.setPrice(34);
    	potatoBag3.setSupplier("Owel");
    	
    	entityManager.persist(potatoBag1);
    	entityManager.persist(potatoBag2);
    	entityManager.persist(potatoBag3);
        entityManager.flush();
        // when
        List<PotatoBag> potatoBagList = potatoBagRepository.findAll((Pageable)PageRequest.of(0,2)).getContent();
     
        assertSame(potatoBagList.size(),2);
     
    }

	

}
