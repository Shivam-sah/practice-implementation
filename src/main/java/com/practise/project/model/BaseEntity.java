package com.practise.project.model;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass  //annotation in JPA (Java Persistence API) marks a class whose fields should be inherited by JPA entities,but the class itself is not a table in the database.
public class BaseEntity implements Serializable{	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	private Integer id;

}
