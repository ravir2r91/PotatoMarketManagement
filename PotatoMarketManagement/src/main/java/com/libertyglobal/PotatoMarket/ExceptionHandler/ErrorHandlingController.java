package com.libertyglobal.PotatoMarket.ExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.libertyglobal.PotatoMarket.model.CustomException;
import com.libertyglobal.PotatoMarket.model.ErrorResponse;

/**
 * Class handling the exceptions centrally. Annotation ControllerAdvice helps to pass all the exceptions
 * through this class. Error responses are properly transformed, formatted using the individual exception  
 * details.
 * 
 * @author Rabindra Rakshit
 */

@ControllerAdvice
public class ErrorHandlingController {
	
	@Autowired
	private ErrorResponse errorResponse;
	
	/**
	 * Method handling the general uncategorized exceptions.
	 * 
	 * @author Rabindra Rakshit
	 */
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> generalException(Exception e) throws Exception {
		errorResponse.setMessage(e.getMessage());
		errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		errorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Method handling the categorized custom exceptions.
	 * 
	 * @author Rabindra Rakshit
	 */
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> customException(CustomException e) throws Exception {
		errorResponse.setMessage(e.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
}
