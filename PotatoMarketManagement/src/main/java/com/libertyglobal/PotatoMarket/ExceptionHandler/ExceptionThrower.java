package com.libertyglobal.PotatoMarket.ExceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.libertyglobal.PotatoMarket.model.CustomException;
import com.libertyglobal.PotatoMarket.model.ErrorResponse;

/**
 * Class containing the method throwCustomException which is used to throw custom exceptions.
 * 
 * @author Rabindra Rakshit
 */

@Component
public class ExceptionThrower {
	
	@Autowired
	CustomException customException;
	
	/**
	 * Method used to throw custom exceptions.
	 * @param
	 * errorResponse Object mentioning the custom exception details.
	 * @author Rabindra Rakshit
	 */
	
	public void throwCustomException(ErrorResponse errorResponse) throws CustomException{
		customException.setError(errorResponse.getError());
		customException.setMessage(errorResponse.getMessage());
		customException.setPath(errorResponse.getPath());
		customException.setStatus(errorResponse.getStatus());
		customException.setTimestamp(errorResponse.getTimestamp());
		
		throw customException;
		
	}
}
