package com.practise.project.entity;

import java.util.HashSet;
import java.util.Set;
import com.practise.project.model.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_department")
public class Department extends AuditableEntity{
		
	@Column(name = "dept_name", nullable = false , /*unique = true */length  = 50)
	private String deptName;
	
	@Column(name = "dept_Code", nullable = false,  /*unique = true */  length = 10)
	private String deptCode;	
	
	@Column(name = "description", nullable = false )
	private String description;	
	
	@OneToMany(mappedBy = "department" )
	private Set<Employee> employees =  new HashSet<>();	
}
	//manager
