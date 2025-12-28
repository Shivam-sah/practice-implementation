package com.practise.project.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class AuditableEntity extends BaseEntity {
	
	//  @CreatedBy
	  @Column(name = "created_by", columnDefinition = "int4", updatable = false)
	  private Integer createdBy;
	  
	  @CreatedDate
	  @Column(name = "created_on", columnDefinition = "timestamp", updatable = false)
	  private LocalDateTime createdOn;
	  
	//  @LastModifiedBy
	  @Column(name = "modified_by", columnDefinition = "int4")
	  private Integer modifiedBy;
	  
	  @LastModifiedDate
	  @Column(name = "modified_on", columnDefinition = "timestamp")
	  private LocalDateTime modifiedOn;
	  
	  @Column(name = "active", columnDefinition = "boolean")
	  private Boolean active = true ;
}
