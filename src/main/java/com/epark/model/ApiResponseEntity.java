package com.epark.model;




import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApiResponseEntity {
	private String message;
	
	private Object data;
	
	private boolean status;
	
	private HttpStatus httpStatus;
	
	private int httpStatusCode;
	
	private Date timeStamp;
	
	
	
} 
