package com.epark.dto;

import java.util.List;

import com.epark.model.UserRole;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
//@Entity
public class LoginDto {
	
	private long id;
	private String password;

}
