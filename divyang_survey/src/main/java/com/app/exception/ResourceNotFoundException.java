package com.app.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	String resouceName;
	String fieldName;
	long fieldValue;
	
	public ResourceNotFoundException(String resouceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %l",resouceName, fieldName,fieldValue));
		this.resouceName = resouceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}