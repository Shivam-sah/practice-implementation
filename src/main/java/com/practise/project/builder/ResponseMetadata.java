package com.practise.project.builder;

import lombok.Data;

@Data
public class ResponseMetadata {
	private static final long serialVersionUID = 5616720503120832647L;
	  
	  private Integer pageNumber;
	  
	  private Integer pageSize;
	  
	  private Long totalElements;
	  
	  private Integer totalPages;
	  
	  private Boolean firstPage;
	  
	  private Boolean lastPage;
	  
	  private long timestamp;
	  
	  private String correlationId;

}
