package com.epark.exception;

public class CategoryAlreadyExistException extends RuntimeException {
	public CategoryAlreadyExistException(String msg) {
		super(msg);
	} 
}
