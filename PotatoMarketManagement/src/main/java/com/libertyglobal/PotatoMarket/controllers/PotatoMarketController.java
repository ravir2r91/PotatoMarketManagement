package com.libertyglobal.PotatoMarket.controllers;

import java.time.LocalDateTime;
import java.util.Collection;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.libertyglobal.PotatoMarket.ExceptionHandler.ExceptionThrower;
import com.libertyglobal.PotatoMarket.model.CustomException;
import com.libertyglobal.PotatoMarket.model.ErrorResponse;
import com.libertyglobal.PotatoMarket.model.PotatoBag;
import com.libertyglobal.PotatoMarket.model.PotatoBags;
import com.libertyglobal.PotatoMarket.service.PotatoMarketService;

/**
 * Controller exposing REST API endpoints for the resource Potato Bag. Here the controller exposes two methods:
 * <br>
 * 1. GET : Fetch requested number of Potato Bags. Quantity is mentioned in query parameter. If not mentioned default is 3.
 * <br>
 * 2. POST : Add a potato bag to the list of Potato Bags.
 * 
 * @author Rabindra Rakshit
 * 
 */

@RestController
public class PotatoMarketController {
	@Autowired
	private PotatoMarketService potatoMarketService;
	@Autowired
	private PotatoBags potatoBags;
	@Autowired
	private ErrorResponse errorResponse;
	@Autowired
	private ExceptionThrower exceptionThrower;
	
	/**
	 * POST method allowing to add a Potato Bag with validated details.
	 * 
	 * @param 
	 * potatoBag Parameter containing the resource Potato Bag details.
	 * @param
	 * errors Parameter containing the error details if any.
	 * @return
	 * Details of the Potato Bag added to the list.
	 * @author Rabindra Rakshit
	 */
	
	@RequestMapping(value = "/PotatoBag", method = RequestMethod.POST)
	public Object newPotatoBag(@Valid @RequestBody PotatoBag potatoBag, Errors errors) throws CustomException {
		System.out.println(potatoBag.toString());
		
		if (errors.hasErrors()) {			
			errorResponse.setTimestamp(LocalDateTime.now());
			errorResponse.setPath("/PotatoBag");
			errorResponse.setStatus(HttpStatus.BAD_REQUEST);
			errorResponse.setError(errors.getAllErrors());
			errorResponse.setMessage("Error while performing the transaction");
	        exceptionThrower.throwCustomException(errorResponse);
	    }
				
		PotatoBag potatoBagInstance=potatoMarketService.addPotatoBag(potatoBag);
		return (potatoBagInstance);
	}
	
	/*@RequestMapping(value = "/PotatoBag/{potatoBagId}", method = RequestMethod.GET)
	public Optional<PotatoBag> newPotatoBag(@PathVariable("potatoBagId") String potatoBagId) {
		System.out.println("potatoBagId: "+potatoBagId);
		Optional<PotatoBag> potatoBagInstance=potatoBagData.findById(Long.valueOf(potatoBagId));
		return (potatoBagInstance);
	}*/
	
	/**
	 * GET method allowing to fetch the mentioned number of Potato Bags.
	 * Quantity is mentioned in query parameter (itemCount). If not mentioned default is 3. 
	 * @param
	 * itemCount Parameter mentioning the number of Potato Bag details to be fetched.
	 * @return
	 * Details of the requested number of Potato Bags.
	 * @author Rabindra Rakshit
	 */
	
	@RequestMapping(value = "/PotatoBag", method = RequestMethod.GET, produces = "application/json")
	public PotatoBags listPotatoBags(@RequestParam(value="itemCount", defaultValue = "3") String itemCount) {
		int count=Integer.parseInt(itemCount);
		Collection<PotatoBag> potatoBagList=potatoMarketService.getPotatoBagList((Pageable)PageRequest.of(0, count));
		potatoBags.setPotatoBagList(potatoBagList);
		return potatoBags;
	}
}
