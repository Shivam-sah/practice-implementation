package com.practise.project.builder;

import java.io.Serializable;
import lombok.Data;

@Data
public class FieldError implements Serializable{
	
	private String field;	  
	private String error;	  
	private String errorCode;
}
