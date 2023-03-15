package com.epark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> handleException(RecordNotFoundException exception) {

		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	} 
	@ExceptionHandler(CategoryAlreadyExistException.class)
	public ResponseEntity<String> handleException(CategoryAlreadyExistException exception) {
		
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
	}
	@ExceptionHandler(EmailAlreadyExistException.class)
	public ResponseEntity<String> handleException(EmailAlreadyExistException exception) {
		
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
	}
	@ExceptionHandler(EventBookingDateAlreadyExistException.class)
	public ResponseEntity<String> handleException(EventBookingDateAlreadyExistException exception) {
		
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
	}
	/*
	 * @ExceptionHandler(InvalidinputException.class) public ResponseEntity<String>
	 * handleException(InvalidinputException exception) {
	 * 
	 * return new ResponseEntity<String>(exception.getMessage(),
	 * HttpStatus.NOT_FOUND); }
	 */
}
