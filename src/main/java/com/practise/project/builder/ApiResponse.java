package com.practise.project.builder;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ApiResponse implements Serializable{
	
	  private static final long serialVersionUID = 2203986815774042259L;
	  
	  private String status;
	  
	  private String message;
	  
	  private String statusCode;
	  
	  private transient Object data;
	  
	  private ResponseMetadata meta;
	  
	  private List<FieldError> errors;
}
