package com.practise.project.builder;

import java.io.Serializable;
import lombok.Data;

@Data
public class FieldError implements Serializable{
	
	private String field;	  
	private String error;	  
	private String errorCode;
	
	public FieldError(String field, String error) {
        this.field = field;
        this.error = error;
    }
}
