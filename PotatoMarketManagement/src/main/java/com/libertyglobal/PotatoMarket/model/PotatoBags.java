package com.libertyglobal.PotatoMarket.model;

import java.util.Collection;
import org.springframework.stereotype.Component;

/**
 * Model Class defining the structure of Potato Bag resource list. 
 * 
 * @author Rabindra Rakshit
 */

@Component
public class PotatoBags {
	private Collection<PotatoBag> potatoBagList;

	public Collection<PotatoBag> getPotatoBagList() {
		return potatoBagList;
	}

	public void setPotatoBagList(Collection<PotatoBag> potatoBagList) {
		this.potatoBagList = potatoBagList;
	}
}
