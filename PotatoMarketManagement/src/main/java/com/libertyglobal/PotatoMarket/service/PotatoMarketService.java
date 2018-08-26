package com.libertyglobal.PotatoMarket.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.libertyglobal.PotatoMarket.data.PotatoBagRepository;
import com.libertyglobal.PotatoMarket.model.PotatoBag;

/**
 * Class defining the service layer of the Potato Market Management Application. It contains two methods
 * addPotatoBag and getPotatoBagList to serve controller requests for POST and GET methods of Potato Bag resource respectively.
 * 
 * @author Rabindra Rakshit
 */

@Service
public class PotatoMarketService {
	@Autowired
	private PotatoBagRepository potatoBagData;
	
	public PotatoBag addPotatoBag(PotatoBag potatoBag) {
		PotatoBag potatoBagInstance=potatoBagData.save(potatoBag);
		return potatoBagInstance;
	}
	
	public Collection<PotatoBag> getPotatoBagList(Pageable pageable){
		Page<PotatoBag> potatoBagPages=potatoBagData.findAll(pageable);
		Collection<PotatoBag> potatoBagList=potatoBagPages.getContent();
		return potatoBagList;
	}

}
