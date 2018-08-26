package com.libertyglobal.PotatoMarket.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.libertyglobal.PotatoMarket.model.*;

/**
 * Class extending JPA Repository allowing classes to interact with backend in-memory H2 database. 
 * 
 * @author Rabindra Rakshit
 */

public interface PotatoBagRepository extends JpaRepository<PotatoBag, Long> {
	
}