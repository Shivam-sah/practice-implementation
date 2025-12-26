package com.practise.project.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	  
	    public ResponseMetadata(Integer pageNumber, Integer pageSize, Long totalElements, Integer totalPages, Boolean firstPage, Boolean lastPage) {
	        this.pageNumber = pageNumber;
	        this.pageSize = pageSize;
	        this.totalElements = totalElements;
	        this.totalPages = totalPages;
	        this.firstPage = firstPage;
	        this.lastPage = lastPage;
	    }

}
