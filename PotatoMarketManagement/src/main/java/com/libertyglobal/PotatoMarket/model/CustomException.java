package com.libertyglobal.PotatoMarket.model;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

/**
 * Custom Exception class extending Exception class used to throw custom exceptions. 
 * 
 * @author Rabindra Rakshit
 */

@Component
public class CustomException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private LocalDateTime timestamp;
	private HttpStatus status;
	private List<ObjectError> error;
	private String message;
	private String path;
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public List<ObjectError> getError() {
		return error;
	}
	public void setError(List<ObjectError> error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
